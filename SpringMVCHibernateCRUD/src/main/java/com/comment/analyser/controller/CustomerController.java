package com.comment.analyser.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.comment.analyser.model.Customer;
import com.comment.analyser.model.CustomerDto;
import com.comment.analyser.model.Login;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.service.CustomerService;
import com.comment.analyser.service.LoginService;

@Controller
public class CustomerController { 

	private static final Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/viewusers")
	public ModelAndView showCustomerList(ModelAndView model) throws IOException {
		logger.trace("CustomerController showCustomerList start");
		List<Customer> listCustomer = customerService.getAllCustomer();
		model.addObject("listCustomer", listCustomer);
		model.setViewName("viewusers");
		logger.trace("CustomerController showCustomerList end");
		return model;
	}

	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView addNewContact(ModelAndView model) {
		logger.trace("CustomerController addNewContact start");
		CustomerDto customer = new CustomerDto();
		model.addObject("customer", customer);
		model.setViewName("customerForm");
		logger.trace("CustomerController addNewContact start");
		return model;
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer, @ModelAttribute Login login) {
		logger.trace("CustomerController saveCustomer start");
		logger.debug("if employee id is 0 then creating the employee otherwise updating the employee");
		if (customer.getId() == 0)
		{
			int cust_id = customerService.addCustomer(customer);
			logger.debug("Cust_id=" + customer.getId());
			login.setCustomer_id(cust_id);
			loginService.addLogin(login);
		} 
		else 
		{
			customerService.updateCustomer(customer);
			loginService.updateLogin(login);
		}
		logger.trace("CustomerController saveCustomer end");
		return new ModelAndView("redirect:/");
	}


	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request) {
		logger.trace("CustomerController deleteCustomer start");
		int customerId = Integer.parseInt(request.getParameter("id"));
		customerService.deleteCustomer(customerId);
		loginService.deleteLogin(customerId);
		logger.trace("CustomerController deleteCustomer end");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		logger.trace("CustomerController editContact start");
		int customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerService.getCustomer(customerId);
		Login login = loginService.getLogin(customerId);
		CustomerDto customerDto = new CustomerDto();
		customerDto.setUsername(login.getUsername());
		customerDto.setPassword(login.getPassword());
		customerDto.setId(customer.getId());
		customerDto.setEmail(customer.getEmail());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setAddress(customer.getAddress());
		customerDto.setTelephone(customer.getTelephone());
		ModelAndView model = new ModelAndView("customerForm");
		model.addObject("customer", customerDto);
		logger.trace("CustomerController editContact end");
		return model;
	}

	@RequestMapping(value = "/backtologin")
	public ModelAndView backToLogin(ModelAndView model) {
		logger.trace("CustomerController backToLogin start");
		Login login = new Login();
		model.addObject("login", login);
		model.setViewName("LoginForm");
		logger.trace("CustomerController backToLogin end");
		return model;
	}

	@RequestMapping(value = "/CustomerHome")
	public ModelAndView gotoCustomerHome(ModelAndView model) {
		logger.trace("CustomerController customerHome start");
		UserComment userComment = new UserComment();
		model.addObject("userComment", userComment);
		model.setViewName("customerHome");
		logger.trace("CustomerController backToLogin end");
		return model;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView seeContactInfo(ModelAndView model) {
		logger.trace("CustomerController seeContactInfo start");
		model.setViewName("contact");
		logger.trace("CustomerController seeContactInfo end");
		return model;
	}

	@RequestMapping(value = "/about")
	public ModelAndView seeAboutInfo(ModelAndView model) {
		logger.trace("CustomerController seeAboutInfo start");
		model.setViewName("about");
		logger.trace("CustomerController seeAboutInfo end");
		return model;
	}
}