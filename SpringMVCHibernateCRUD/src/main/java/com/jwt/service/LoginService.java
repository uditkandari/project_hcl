package com.jwt.service;

import java.util.List;

import com.jwt.model.Login;


public interface LoginService {

	public void addLogin(Login login);

	public List<Login> getAllLogin();

	public void deleteLogin(Integer loginId);

	public Login getLogin(int loginid);

	public Login updateLogin(Login login);
	
	public boolean validateCustomer(Login login);
}
