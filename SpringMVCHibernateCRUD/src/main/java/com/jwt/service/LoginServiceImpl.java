package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.LoginDAO;
import com.jwt.model.Login;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Override
	@Transactional
	public void addLogin(Login login) {
		loginDAO.addLogin(login);
	}

	@Override
	@Transactional
	public List<Login> getAllLogin() {

		return loginDAO.getAllLogin();
	}

	@Override
	@Transactional
	public void deleteLogin(Integer loginId) {
		loginDAO.deleteLogin(loginId);

	}

	@Override
	public Login getLogin(int loginid) {

		return loginDAO.getLogin(loginid);
	}

	@Override
	public Login updateLogin(Login login) {
		// TODO Auto-generated method stub
		return loginDAO.updateLogin(login);
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public boolean validateCustomer(Login login) {
		Login loginData = loginDAO.getLogin(login);
		if (loginData != null) {
			return true;
		} else {
			return false;
		}
	}
}
