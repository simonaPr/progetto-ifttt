package it.polito.ai.ifttt.progetto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Users {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column
	String username;
	@Column
	String password;
	@Column
	String email;
	@ColumnDefault("false")
	Boolean enabled = false;
	@Column
	String urlactivate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getUrlactivate() {
		return urlactivate;
	}
	public void setUrlactivate(String urlactivate) {
		this.urlactivate = urlactivate;
	}	
	
}
