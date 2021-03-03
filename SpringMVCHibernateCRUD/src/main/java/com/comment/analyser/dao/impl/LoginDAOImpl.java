package com.comment.analyser.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.comment.analyser.dao.LoginDAO;
import com.comment.analyser.model.Customer;
import com.comment.analyser.model.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);
	
	@Override
	public void addLogin(Login login) {
		sessionFactory.getCurrentSession().saveOrUpdate(login);
	}

	@Override
	public List<Login> getAllLogin() {
		// TODO Auto-generated method stub
		logger.debug("--Log-Debug--Returning list of Login details--");
		return sessionFactory.getCurrentSession().createQuery("from Login").list();
	}

	@Override
	public Login getLogin(Login login) {
		logger.debug("--Log-Debug--Valaditing username and password with the database--");
		Query query = sessionFactory.getCurrentSession().createQuery("from Login where username=:userName and password = :password")
				.setParameter("userName", login.getUsername())
				.setParameter("password", login.getPassword());
		
		Login userLogin =(Login) query.uniqueResult();
		return userLogin;
	}

	@Override
	public void deleteLogin(Integer loginId) {
		Login login = (Login) sessionFactory.getCurrentSession().load(Login.class, loginId);

		if (null != login) {
			this.sessionFactory.getCurrentSession().delete(login);
			logger.info("--Log-Info--Deleted login details--");
		}
	}

	@Override
	public Login getLogin(int loginId) {

		return (Login) sessionFactory.getCurrentSession().get(Login.class, loginId);
	}

	@Override
	public Login updateLogin(Login login) {
		logger.debug("--Log-Debug--Updating login--");
		sessionFactory.getCurrentSession().update(login);
		
		return login;
	}

	@Override
	public List<Login> validateLogin() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Login").list();
	}

}
