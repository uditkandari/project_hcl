package com.comment.analyser.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.comment.analyser.model.Login;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.service.LoginService;

@Controller
@SessionAttributes("user_session")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/")
	public ModelAndView signIn(ModelAndView model) throws IOException {
		logger.debug("Application started and redirected to login form");
		Login login = new Login();
		model.addObject("login", login);
		model.setViewName("LoginForm");
		return model;
	}

	@RequestMapping(value = "/signinValidation")
	public String signinValidation( @Valid @ModelAttribute("login")Login login,@RequestParam String username,BindingResult bindingResult, Model model) {
		logger.debug("Request for signIn received");
		model.addAttribute("login",login);
		if (bindingResult.hasErrors()) {
			logger.debug("username and password are entered null");
			return"LoginForm";
		} 
		else 
		{
			logger.debug("Sending entered login details to loginService validateCustomer");
			if (loginService.validateCustomer(login)) {
				logger.debug("login details are validated");
				model.addAttribute("user_session", username.toUpperCase());
				model.addAttribute("userComment", new UserComment());
				return "customerHome";
			} else {
				model.addAttribute("loginerror", "Wrong username or password");
				logger.debug("login details failed to validate so return back to login page");
				return "LoginForm";
			}
		}
	}
	
	
}
