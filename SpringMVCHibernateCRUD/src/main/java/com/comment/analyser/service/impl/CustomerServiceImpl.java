package com.comment.analyser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comment.analyser.dao.CustomerDAO;
import com.comment.analyser.model.Customer;
import com.comment.analyser.service.CustomerService;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public int addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		return customerDAO.getAllCustomer();
	}

	@Transactional
	@Override
	public void deleteCustomer(Integer customerId) {
		customerDAO.deleteCustomer(customerId);
	}

	@Override
	@Transactional
	public Customer getCustomer(int cusid) {
		return customerDAO.getCustomer(cusid);
	}

	@Override
	@Transactional
	public Customer getCustomer(Customer customer) {
		return customerDAO.getCustomer(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		return customerDAO.updateCustomer(customer);
	}

	@Transactional
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}

	
}
