package com.jwt.dao;

import java.util.List;

import com.jwt.model.Customer;

public interface CustomerDAO {

	public void addCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public void deleteCustomer(Integer customerId);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int customerid);
}
