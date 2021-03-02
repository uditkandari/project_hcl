package com.comment.analyser.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comment.analyser.dao.CustomerDAO;
import com.comment.analyser.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public int addCustomer(Customer customer) {
		//sessionFactory.getCurrentSession().saveOrUpdate(customer);
		int save = (int)sessionFactory.getCurrentSession().save(customer);
		System.out.println("UK:-"+save);
		return save;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {

		return sessionFactory.getCurrentSession().createQuery("from Customer")
				.list();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(
				Customer.class, customerId);
		if (null != customer) {
			this.sessionFactory.getCurrentSession().delete(customer);
		}

	}

	public Customer getCustomer(int cusid) {
		return (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, cusid);
	}
	public Customer getCustomer(Customer customer) {
		return (Customer) sessionFactory.getCurrentSession().get(
				Customer.class, customer);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		return customer;
	}

}