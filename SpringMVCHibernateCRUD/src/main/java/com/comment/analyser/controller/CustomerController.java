package com.comment.analyser.controller;

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

import com.comment.analyser.model.Customer;
import com.comment.analyser.model.CustomerDto;
import com.comment.analyser.model.Login;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.service.CustomerService;
import com.comment.analyser.service.LoginService;

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
		model.setViewName("customerForm");
		return model;
	}

//	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
//	public ModelAndView saveCustomer(@ModelAttribute Customer customer, @ModelAttribute Login login) {
//		if (customer.getId() == 0) { 
//			// if employee id is 0 then creating the
//			// employee other updating the employee
//			int cust_id = customerService.addCustomer(customer);
//			System.out.println("Cust_id="+customer.getId());
//			login.setCustomer_id(cust_id);
//			loginService.addLogin(login);
//		} else {
//			customerService.updateCustomer(customer);
//			loginService.updateLogin(login);
//		}
//		return new ModelAndView("redirect:/");
//	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer, @ModelAttribute Login login) {
		if (customer.getId() == 0) { 
			// if employee id is 0 then creating the
			// employee other updating the employee
			int cust_id = customerService.addCustomer(customer);
			System.out.println("Cust_id="+customer.getId());
			login.setCustomer_id(cust_id);
			loginService.addLogin(login);
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
		loginService.deleteLogin(customerId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
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
		model.setViewName("customerHome");
		return model;		
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact(ModelAndView model){		
		model.setViewName("contact");
		return model;		
	}

	@RequestMapping(value = "/about")
	public ModelAndView about(ModelAndView model){		
		model.setViewName("about");
		return model;		
	}
}