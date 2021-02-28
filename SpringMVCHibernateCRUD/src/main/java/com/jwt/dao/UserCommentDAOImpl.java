package com.jwt.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.UserComment;

@Repository
public class UserCommentDAOImpl implements UserCommentDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addComment(UserComment comment)
	{

		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserComment> getAllComment() {
		
		return sessionFactory.getCurrentSession().createQuery("from UserComment").list();
	}

	@Override
	public UserComment updateUserComment(UserComment comment) {
		sessionFactory.getCurrentSession().update(comment);
		return comment;
	}

	@Override
	public UserComment getUserComment(int commentNo) {
		
		return (UserComment) sessionFactory.getCurrentSession().get(UserComment.class, commentNo);
	}

}
