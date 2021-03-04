package com.comment.analyser.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comment.analyser.model.UserComment;
import com.comment.analyser.service.UserCommentService;

@Controller
public class UserCommentController 
{

	private static final Logger logger = Logger.getLogger(UserCommentController.class);

	@Autowired
	private UserCommentService userCommentService;

	@RequestMapping(value = "/postcomment")
	public ModelAndView postComment(@ModelAttribute UserComment userComment, ModelAndView model) 
	{
		logger.trace("UserCommentController postComment start");
		userCommentService.addComment(userComment);
		model.setViewName("customerHome");
		logger.trace("UserCommentController postComment end");
		return model;
	}

	@RequestMapping(value = "/analysis")
	public ModelAndView analyseComment(@ModelAttribute UserComment userComment, ModelAndView model) 
	{
		logger.trace("UserCommentController analyseComment start");
		model.setViewName("analysis");
		logger.trace("UserCommentController analyseComment end");
		return model;
	}

	@RequestMapping(value = "/viewComment")
	public ModelAndView showListOfComment(ModelAndView model) throws IOException {
		logger.trace("UserCommentController showListOfComment start");
		List<UserComment> listComment = userCommentService.getAllComment();
		model.addObject("listComment", listComment);
		model.setViewName("analysis");
		logger.trace("UserCommentController showListOfComment end");
		return model;
	}
	
	
}
