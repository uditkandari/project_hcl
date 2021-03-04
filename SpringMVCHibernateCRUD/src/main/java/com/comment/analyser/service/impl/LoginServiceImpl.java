package com.comment.analyser.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comment.analyser.dao.LoginDAO;
import com.comment.analyser.model.Login;
import com.comment.analyser.processing.CommentAnalyser;
import com.comment.analyser.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService 
{

	private static final Logger logger = Logger.getLogger(CommentAnalyser.class);
	
	@Autowired
	private LoginDAO loginDAO;

	@Override
	@Transactional
	public void addLogin(Login login) 
	{
		loginDAO.addLogin(login);
	}

	@Override
	@Transactional
	public List<Login> getAllLogin() 
	{

		return loginDAO.getAllLogin();
	}

	@Override
	@Transactional
	public void deleteLogin(Integer loginId) 
	{
		loginDAO.deleteLogin(loginId);

	}

	@Override
	public Login getLogin(int loginid) 
	{

		return loginDAO.getLogin(loginid);
	}

	@Override
	public Login updateLogin(Login login) 
	{
		
		return loginDAO.updateLogin(login);
	}

	public void setLoginDAO(LoginDAO loginDAO) 
	{
		this.loginDAO = loginDAO;
	}

	@Override
	public boolean validateCustomer(Login login) 
	{
		logger.debug("Reciving entered login details in loginService validateCustomer");
		logger.debug("Sending entered login details to loginDAO getLogin");
		Login loginData = loginDAO.getLogin(login);
		if (loginData != null) 
		{
			logger.debug("recived unique value from database");
			return true;
		}
		else 
		{
			logger.debug("recived null value from database");
			return false;
		}
	}
}
