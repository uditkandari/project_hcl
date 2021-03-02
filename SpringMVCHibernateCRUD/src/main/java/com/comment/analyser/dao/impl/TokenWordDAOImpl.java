package com.comment.analyser.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
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
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TokenWords> getAllWords() 
	{	
		return sessionFactory.getCurrentSession().createQuery("from TokenWords").list();
	}

}
