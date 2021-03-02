package com.comment.analyser.dao;

import java.util.List;

import com.comment.analyser.model.Customer;

public interface CustomerDAO {

	public int addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public void deleteCustomer(Integer customerId);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int customerid);
	public Customer getCustomer(Customer customer);
}
