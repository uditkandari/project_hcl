package com.jwt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Login;
import com.jwt.model.UserComment;
import com.jwt.service.LoginService;

@Controller
public class LoginController {

	public LoginController() {
		System.out.println("LoginController()");
	}

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/")
	public ModelAndView signIn(ModelAndView model) throws IOException {
		Login login = new Login();
		model.addObject("login", login);
		model.setViewName("LoginForm");
		return model;
	}

	@RequestMapping(value = "/signinValidation")
	public ModelAndView signinValidation(@ModelAttribute Login login, ModelAndView model) {
		if (loginService.validateCustomer(login)) {
			model.setViewName("customerhome");
			UserComment userComment = new UserComment();
			model.addObject("userComment", userComment);
			return model;
		} else {
			model.setViewName("LoginForm");
			return model;
		}
	}

}
