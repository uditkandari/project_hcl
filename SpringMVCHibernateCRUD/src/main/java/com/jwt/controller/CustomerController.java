package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Customer;
import com.jwt.model.CustomerDto;
import com.jwt.model.Login;
import com.jwt.model.UserComment;
import com.jwt.service.CustomerService;
import com.jwt.service.LoginService;

@Controller
public class CustomerController {

	private static final Logger logger = Logger
			.getLogger(CustomerController.class);

	public CustomerController() {
		System.out.println("CustomerController()");
	}

	@Autowired
	private CustomerService customerService;
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/viewusers")
	public ModelAndView listCustomer(ModelAndView model) throws IOException {
		List<Customer> listCustomer = customerService.getAllCustomer();
		model.addObject("listCustomer", listCustomer);
		model.setViewName("viewusers");
		return model;
	}

	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		//TODO have to ...
		CustomerDto customer = new CustomerDto();
		model.addObject("customer", customer);
		model.setViewName("CustomerForm");
		return model;
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer, @ModelAttribute Login login) {
		if (customer.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			
			int cust_id = customerService.addCustomer(customer);
			System.out.println("Cust_id="+customer.getId());
			login.setCustomer_id(cust_id);
			loginService.addLogin(login);
//			System.out.println(login.getUsername());
		} else {
			customerService.updateCustomer(customer);
			loginService.updateLogin(login);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request) {
		int customerId = Integer.parseInt(request.getParameter("id"));
		customerService.deleteCustomer(customerId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerService.getCustomer(customerId);
		ModelAndView model = new ModelAndView("CustomerForm");
		model.addObject("customer", customer);

		return model;
	}

	@RequestMapping(value = "/backtologin")
	public ModelAndView backToLogin(ModelAndView model){
		Login login = new Login();
		model.addObject("login", login);
		model.setViewName("LoginForm");
		return model;		
	}

	@RequestMapping(value = "/CustomerHome")
	public ModelAndView customerHome(ModelAndView model){
		UserComment userComment = new UserComment();
		model.addObject("userComment", userComment);
		model.setViewName("customerhome");
		return model;		
	}

}