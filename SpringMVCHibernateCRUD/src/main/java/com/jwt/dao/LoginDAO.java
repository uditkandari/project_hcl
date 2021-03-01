package com.jwt.dao;

import java.util.List;

import com.jwt.model.Login;

public interface LoginDAO {
	
	public void addLogin(Login login);

	public List<Login> getAllLogin();

	public void deleteLogin(Integer customerId);

	public Login getLogin(int customerid);

	public Login updateLogin(Login login);

	public List<Login> validateLogin();

	Login getLogin(Login login);
}
