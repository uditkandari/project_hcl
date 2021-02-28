package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jwt.service.UserCommentService;

@Controller
public class CommentController 
{

	public CommentController() {
		System.out.println("CommentController()");
	}
	
	@Autowired
	private UserCommentService userCommentService;
	
	
	
}
