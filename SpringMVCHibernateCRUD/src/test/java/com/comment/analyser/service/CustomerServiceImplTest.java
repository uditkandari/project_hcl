package com.comment.analyser.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Test;

import com.comment.analyser.dao.CustomerDAO;
import com.comment.analyser.model.Customer;
import com.comment.analyser.service.impl.CustomerServiceImpl;

public class CustomerServiceImplTest 
{
	@Test
	void testGetCustomer() 
	{
		CustomerDAO customerDAO = EasyMock.createMock(CustomerDAO.class); 
		EasyMock.expect(customerDAO.getCustomer(1)).andReturn(null);
		EasyMock.replay(null);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerDAO(customerDAO);
		Customer expected = customerServiceImpl.getCustomer(1);
		assertNotNull(expected);
		assertEquals(expected, null);
		
	}
	
}
