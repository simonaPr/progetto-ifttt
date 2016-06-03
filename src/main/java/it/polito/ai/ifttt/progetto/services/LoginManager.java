package it.polito.ai.ifttt.progetto.services;

public interface LoginManager {
	
	//to register a new user
	int register(String username, String password, String email);
	
	//to do login for user already registered
	int login(String username, String password);
	
	//to check if the user account is still valid
	int activate(Integer id, String url);
}
