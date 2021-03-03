package com.comment.analyser.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comment.analyser.dao.TokenWordDAO;
import com.comment.analyser.model.TokenWords;
import com.comment.analyser.model.UserComment;

@Repository
@Transactional
public class TokenWordDAOImpl implements TokenWordDAO
{
	private static final Logger logger = Logger.getLogger(TokenWordDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TokenWords> getAllWords() 
	{	
		logger.debug("--Log-Debug--Returning list of all token words");
		return sessionFactory.getCurrentSession().createQuery("from TokenWords").list();
	}

}
