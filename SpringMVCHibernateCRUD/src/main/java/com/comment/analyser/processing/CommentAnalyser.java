package com.comment.analyser.processing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.analyser.dao.TokenWordDAO;
import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.TokenWords;
import com.comment.analyser.model.UserComment;

@Service
public class CommentAnalyser
{

	@Autowired
	TokenWordDAO tokenWordsDAO;

	@Autowired
	private UserCommentDAO userCommentDAO;

	public void processComment(UserComment userComment) 
	{
		List<TokenWords> tokenWords = tokenWordsDAO.getAllWords();

		String comment= userComment.getUserComment();
		//TODO filter
		comment = comment.replaceAll(",", "");
		comment = comment.replaceAll("\\.", "");
		int rating = 0;
		//write logic and return rating 
		String[] splittComment = comment.split(" ");
		//int length = comment.length();
		int count=0;
		int weightage=0;
		for (String string : splittComment) 
		{
			for (TokenWords token : tokenWords) 
			{		
				if(string.equals(token.getToken())) 
				{
					weightage+=token.getWeightage();
					count++;
					break;
				}
			}
		}
		try {
			rating = weightage/count;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		userComment.setCommentValue(rating);
		userCommentDAO.updateUserComment(userComment);
		//save
	}
}