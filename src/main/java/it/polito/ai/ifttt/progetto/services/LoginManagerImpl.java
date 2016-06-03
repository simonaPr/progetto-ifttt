package it.polito.ai.ifttt.progetto.services;

import java.util.List;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import it.polito.ai.ifttt.progetto.models.Users;

public class LoginManagerImpl implements LoginManager {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	javax.mail.Session sessionMail;

	@SuppressWarnings({ "unchecked", "static-access" })
	public int register(String username, String password, String email) {

		// open session
		Session session = sessionFactory.openSession();

		try {
			// begin transaction
			Transaction tx = session.beginTransaction();
			try {
				
				if(password.length()<8) {
					return 4;
				}
				if(username.length()<4) {
					return 5;
				}
				// compute hash (MD5) of the user password to store it in an
				// encrypted way
				String hashpass = this.computeMD5(password);

				// create and check the uniqueness of the string associated to
				// the user; string to send by email to activate the account
				Boolean unique = false;
				String url = UUID.randomUUID().toString();
				while (unique == false) {
					String hql2 = "from it.polito.ai.ifttt.progetto.models.Users u where u.urlactivate=:n";
					Query query2 = session.createQuery(hql2);
					query2.setString("n", url);
					List<Users> users = query2.list();
					if (users.size() == 0) {
						unique = true;
					} else {
						url = UUID.randomUUID().toString();
					}
				}

				// check if the provided username already exists
				String hql = "from it.polito.ai.ifttt.progetto.models.Users u where u.username=:n";
				Query query = session.createQuery(hql);
				query.setString("n", username);
				List<Users> users = query.list();
				if (users.size() != 0) {
					// user already exists --> 1
					return 1;
				}

				// check if the provided email has a valid format
				if (email.indexOf('@') == -1) {
					// email NOT valid --> 3
					return 3;
				}

				// check if the provided email already exists
				String hql1 = "from it.polito.ai.ifttt.progetto.models.Users u where u.email=:n";
				Query query1 = session.createQuery(hql1);
				query1.setString("n", email);
				List<Users> users1 = query1.list();
				if (users1.size() != 0) {
					// email already exists --> 2
					return 2;
				}

				// create a new user with valid information
				Users user = new Users();
				user.setUsername(username);
				user.setPassword(hashpass);
				user.setEmail(email);
				user.setUrlactivate(url);

				// save the new user in the db
				Integer id = (Integer) session.save(user);
				tx.commit();

				// send email with activation link
				// TODO: send email
				try {

					Message message = new MimeMessage(sessionMail);
					message.setFrom(new InternetAddress("ifttt.ai2016@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
					message.setSubject("New Registration");
					message.setText(
							"Dear " + username + "," + "\n\n To complete the registration please follow the link: \n"
									+ "http://localhost:8080/progetto/activation.html?id=" + id + "&url=" + url);

					Transport.send(message);

					System.out.println("Done");

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			} catch (Exception e) {
				// if some errors during the transaction occur,
				// rollback and return code -1
				tx.rollback();
				return -1;
			}
		} finally {
			if (session != null) {
				// close session in any case
				session.close();
			}
		}
		// user insertion: ok
		return 0;
	}

	public int login(String username, String password) {
		// open session
		Session session = sessionFactory.openSession();

		try {
			//compute hash of provided password
			String hashpass = this.computeMD5(password);

			String hql = "from it.polito.ai.ifttt.progetto.models.Users u where u.username=:n and u.password=:p";
			Query query = session.createQuery(hql);
			query.setString("n", username);
			query.setString("p", hashpass);
			List<Users> users = query.list();
			if (users.size() == 0) {
				// user/password wrong
				return 1;
			}
			Users usr = users.get(0);
			if (usr.getEnabled() == false) {
				// not activated
				return 2;
			}

		} catch (Exception e) {
			// if some errors during the transaction occur,
			return -1;
		} finally {
			if (session != null) {
				// close session in any case
				session.close();
			}
		}
		return 0;
	}

	public int activate(Integer id, String url) {

		Session session = sessionFactory.openSession();

		try {
			// begin transaction
			Transaction tx = session.beginTransaction();
			try {
				// retrieve the user with the correct id
				Users usr = session.get(Users.class, id);
				if (usr == null) {
					// user doesn't exist
					return -1;
				}
				if (usr.getEnabled()) {
					// user already activated
					return 1;
				}
				if (usr.getUrlactivate().compareTo(url) != 0) {
					// url wrong
					return -1;
				}

				// enable user and store it in the db
				usr.setEnabled(true);
				session.update(usr);
				tx.commit();
			} catch (Exception e) {
				// if some errors during the transaction occur, rollback
				tx.rollback();
				return -1;
			}
		} finally {
			if (session != null) {
				// close session in any case
				session.close();
			}
		}

		// everything is ok
		return 0;
	}

	// function to compute an MD5 hash of the user password
	public static String computeMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
