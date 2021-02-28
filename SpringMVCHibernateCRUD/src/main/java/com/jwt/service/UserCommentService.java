package com.jwt.service;

import java.util.List;

import com.jwt.model.UserComment;

public interface UserCommentService
{
	public void addComment(UserComment comment);

	List<UserComment> getAllComment();

	public UserComment updateUserComment(UserComment comment);

	public UserComment getUserComment(int commentNo);
}
