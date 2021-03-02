package com.comment.analyser.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comment.analyser.model.Customer;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.service.UserCommentService;

@Controller
public class UserCommentController 
{

	public UserCommentController()
	{
		System.out.println("CommentController()");
	}

	@Autowired
	private UserCommentService userCommentService;

	@RequestMapping(value = "/postcomment")
	public ModelAndView postComment(@ModelAttribute UserComment userComment, ModelAndView model) 
	{
		userCommentService.addComment(userComment);
//		model.setViewName("customerHome");
//		return model;
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/analysis")
	public ModelAndView analyseComment(@ModelAttribute UserComment userComment, ModelAndView model) 
	{
		model.setViewName("analysis");
		return model;
	}
	// TODO create analyze jsp
	@RequestMapping(value = "/viewComment")
	public ModelAndView listComment(ModelAndView model) throws IOException {
		List<UserComment> listComment = userCommentService.getAllComment();
		model.addObject("listComment", listComment);
		model.setViewName("analysis");
		return model;
	}
	
	
}
