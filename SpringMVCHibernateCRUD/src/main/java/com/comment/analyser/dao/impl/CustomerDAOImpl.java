package com.comment.analyser.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comment.analyser.dao.CustomerDAO;
import com.comment.analyser.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(CustomerDAOImpl.class);
	
	public int addCustomer(Customer customer) {
		logger.info("adding new customer to the database");
		int save = (int)sessionFactory.getCurrentSession().save(customer);
		logger.info("added new customer to the database");
		return save;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		logger.info("returning list of all customers from the database");
		return sessionFactory.getCurrentSession().createQuery("from Customer")
				.list();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		logger.info("searching for customer with customer ID " + customerId);
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(
				Customer.class, customerId);
		if (null != customer) {
			logger.info("deleting customer with customer ID " + customerId);
			this.sessionFactory.getCurrentSession().delete(customer);
		}
	}

	public Customer getCustomer(int cusid) {
		logger.info("returning customer with customer ID " + cusid);
		return (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, cusid);
	}
	public Customer getCustomer(Customer customer) {
		logger.info("returning customer details");
		return (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, customer);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		logger.info("updating customer record");
		sessionFactory.getCurrentSession().update(customer);
		return customer;
	}

}