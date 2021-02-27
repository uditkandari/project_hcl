package com.jwt.model;

public class Comment
{
	private int commentNo;
	private String userComment;
	private int commentValue;
	
	public int getCommentNo() 
	{
		return commentNo;
	}
	public void setCommentNo(int commentNo) 
	{
		this.commentNo = commentNo;
	}
	public String getUserComment() 
	{
		return userComment;
	}
	public void setUserComment(String userComment) 
	{
		this.userComment = userComment;
	}
	public int getCommentValue() 
	{
		return commentValue;
	}
	public void setCommentValue(int commentValue) 
	{
		this.commentValue = commentValue;
	}	
}
