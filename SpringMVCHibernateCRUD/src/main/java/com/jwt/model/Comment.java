package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT_TABLE")
public class Comment
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentNo;
	@Column(name = "Comment")
	private String userComment;
	@Column(name = "Comment_Value")
	private int commentValue;
	@Column
	private String commentedBy;
	
	public String getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}
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
