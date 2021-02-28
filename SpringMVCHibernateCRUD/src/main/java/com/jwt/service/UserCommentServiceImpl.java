package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.UserCommentDAO;
import com.jwt.model.UserComment;

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

	@Override
	public UserComment updateUserComment(UserComment comment) {
		
		return userCommentDAO.updateUserComment(comment);
	}

	@Override
	public UserComment getUserComment(int commentNo) {
		return userCommentDAO.getUserComment(commentNo);
	}
	
	public void setUserCommentDAO(UserCommentDAO userCommentDAO) {
		this.userCommentDAO = userCommentDAO;
	}
}
