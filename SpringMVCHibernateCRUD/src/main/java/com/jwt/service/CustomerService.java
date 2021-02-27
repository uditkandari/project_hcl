package com.jwt.service;

import java.util.List;

import com.jwt.model.Customer;


public interface CustomerService {
	
	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public void deleteCustomer(Integer customerId);

	public Customer getCustomer(int customerid);

	public Customer updateCustomer(Customer customer);
}
