package com.jwt.dao;

import java.util.List;

import com.jwt.model.UserComment;

public interface UserCommentDAO 
{
	public void addComment(UserComment comment);
	
	List<UserComment> getAllComment();
	
	public UserComment updateUserComment(UserComment comment);
	
	public UserComment getUserComment(int commentNo);	
	
}
