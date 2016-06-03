package it.polito.ai.ifttt.progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.polito.ai.ifttt.progetto.services.LoginManager;

@Controller
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	LoginManager loginManager;

	@RequestMapping(value="authpage", method=RequestMethod.GET)
	public String main() {
		return "authpage";
	}
	
	@RequestMapping(value="authpage", method=RequestMethod.POST)
	public String loginDone(@RequestParam("username") String username, 
			@RequestParam("password") String password,
			RedirectAttributes attributes) {
		
		int code = loginManager.login(username, password);
		if(code == 0) {
			attributes.addFlashAttribute("msg", "User Logged In");
		}
		else if(code == 1) {
			attributes.addFlashAttribute("msg", "Wrong combination uername/password");
		}
		else if(code == 2) {
			attributes.addFlashAttribute("msg", "User not activated");
		}
		else  if(code == -1){
			attributes.addFlashAttribute("msg", "Some Errors (database)");
		}
	
		return "redirect:/authpage.html";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String register() {
		return "registration";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String registerDone(@RequestParam("username") String username, 
								@RequestParam("password") String password,
								@RequestParam("email") String email,
								RedirectAttributes attributes) {
		
		Integer i = loginManager.register(username, password, email);
		if(i==0) {
			attributes.addFlashAttribute("msg", "Andato a buon fine, email sent");
		}
		else if(i==1) {
			attributes.addFlashAttribute("msg", "User exist");
		}
		else if(i==2) {
			attributes.addFlashAttribute("msg", "Email exist");
		}
		else if(i==3) {
			attributes.addFlashAttribute("msg", "Email not valid");
		}
		else if(i==4) {
			attributes.addFlashAttribute("msg", "Password too short");
		}
		else if(i==5) {
			attributes.addFlashAttribute("msg", "Username too short");
		}
		else if(i==-1) {
			attributes.addFlashAttribute("msg", "Some errors");
		}
		
		return "redirect:/registration.html";
	}	
	
	@RequestMapping(value="activation", method=RequestMethod.GET)
	public String activationDone(@RequestParam(required = false, value="id") Integer id, 
								@RequestParam(required = false,  value="url") String url,
								RedirectAttributes attributes) {		
		/*
		if(id==null && url == null) {
			return "activation";
		}
		else { */
			int code = loginManager.activate(id, url);
			if(code==0) {
				attributes.addFlashAttribute("msg", "Activation Done");
			}
			else if(code==-1) {
				attributes.addFlashAttribute("msg", "Some Errors occured");
			}				
			else if (code==1){
				attributes.addFlashAttribute("msg", "User already Registered");				
			}
			return "redirect:/authpage.html";
	//	}	
	}	
}
