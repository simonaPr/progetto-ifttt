package it.polito.ai.ifttt.progetto.configurations;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import it.polito.ai.ifttt.progetto.models.Users;
import it.polito.ai.ifttt.progetto.services.LoginManager;
import it.polito.ai.ifttt.progetto.services.LoginManagerImpl;

@Configuration
@ComponentScan("it.polito.ai.ifttt.progetto")
public class RootConfig {
		
	@Bean
	SessionFactory sessionFactory() {
		org.hibernate.cfg.Configuration c = new org.hibernate.cfg.Configuration();
		c.setProperty(Environment.USER, "root");
		c.setProperty(Environment.PASS, "mysqladmin");
		c.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		c.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/ifttt");
		c.addAnnotatedClass(Users.class);
	//	c.addAnnotatedClass(Event.class);
		c.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
		c.setProperty(Environment.HBM2DDL_AUTO, "create");
		return c.buildSessionFactory();		
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/esercitazione6");
		ds.setUsername("root");
		ds.setPassword("mysqladmin");
		return ds;
	}
	
	@Bean
	LoginManager loginManager() {
		return new LoginManagerImpl();
	}
	
	@Bean
	Session sessionMail() {
		final String username = "ifttt.ai2016@gmail.com";
		final String password = "iftttai2016";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });		
		return session;
	}
}
