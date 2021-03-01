package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.CustomerDAO;

import com.jwt.model.Customer;


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

	public Customer getCustomer(int cusid) {
		return customerDAO.getCustomer(cusid);
	}

	public Customer getCustomer(Customer customer) {
		return customerDAO.getCustomer(customer);
	}

	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.updateCustomer(customer);
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
