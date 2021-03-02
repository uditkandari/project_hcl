package com.comment.analyser.dao;

import java.util.List;

import com.comment.analyser.model.Customer;
import com.comment.analyser.model.UserComment;

public interface UserCommentDAO 
{
	public void addComment(UserComment comment);
	
	List<UserComment> getAllComment();
		
	public UserComment getUserComment(int commentNo);	
	
	public List<UserComment> getUnprocessedComments();

	UserComment updateUserComment(UserComment comment);
	
}
