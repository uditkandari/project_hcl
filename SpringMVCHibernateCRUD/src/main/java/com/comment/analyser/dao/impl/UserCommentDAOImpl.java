package com.comment.analyser.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.processing.CommentAnalyser;

@Repository
@Transactional
public class UserCommentDAOImpl implements UserCommentDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(UserCommentDAOImpl.class);
	
	@Override
	public void addComment(UserComment comment)
	{

		sessionFactory.getCurrentSession().saveOrUpdate(comment);
		logger.info("--Log-Info--New comment saved--");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserComment> getAllComment() 
	{
		logger.debug("--Log-Debug--Returning list of comments--");
		return sessionFactory.getCurrentSession().createQuery("from UserComment").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserComment> getUnprocessedComments() 
	{
		//TODO default value should be null and not 0, change is later
		logger.debug("--Log-Debug--Returning list of unprocessed comments--");
		return sessionFactory.getCurrentSession().createQuery("from UserComment userComment where userComment.commentValue = 0").list();
	}

	public UserComment getUserComment(int id) 
	{
		
		return (UserComment) sessionFactory.getCurrentSession().get(UserComment.class, id);
	}

	@Override
	public UserComment updateUserComment(UserComment comment) 
	{
		sessionFactory.getCurrentSession().update(comment);
		logger.info("--Log-Info--Rating updated for user comment");
		return comment;
	}
}
