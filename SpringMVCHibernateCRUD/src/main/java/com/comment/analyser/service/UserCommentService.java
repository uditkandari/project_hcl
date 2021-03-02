package com.comment.analyser.service;

import java.util.List;

import com.comment.analyser.model.UserComment;

public interface UserCommentService
{
	public void addComment(UserComment comment);

	List<UserComment> getAllComment();

	public UserComment getUserComment(int commentNo);
	
	public List<UserComment> getUnprocessedComments();
}
