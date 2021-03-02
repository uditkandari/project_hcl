package com.comment.analyser.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.service.UserCommentService;

@Service
@Transactional
public class UserCommentServiceImpl implements UserCommentService {

	@Autowired
	private UserCommentDAO userCommentDAO;
	
	@Override
	@Transactional
	public void addComment(UserComment comment) {
		userCommentDAO.addComment(comment);
	}

	@Override
	@Transactional
	public List<UserComment> getAllComment() {
		
		return userCommentDAO.getAllComment();
	}

	public UserComment getUserComment(int commentNo) {
		return userCommentDAO.getUserComment(commentNo);
	}
	
	public void setUserCommentDAO(UserCommentDAO userCommentDAO) {
		this.userCommentDAO = userCommentDAO;
	}
	
	public List<UserComment> getUnprocessedComments() {
		return userCommentDAO.getUnprocessedComments();
	} 
}
