package com.comment.analyser.service;

import java.util.List;

import com.comment.analyser.model.Customer;


public interface CustomerService {
	
	public int addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public void deleteCustomer(Integer customerId);

	public Customer getCustomer(int customerid);
	public Customer getCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
}
