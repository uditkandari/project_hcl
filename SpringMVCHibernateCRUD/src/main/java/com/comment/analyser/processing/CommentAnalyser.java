package com.comment.analyser.processing;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.analyser.dao.TokenWordDAO;
import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.TokenWords;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.scheduler.SchedulerTask;


@Service
public class CommentAnalyser
{

	@Autowired
	TokenWordDAO tokenWordsDAO;

	@Autowired
	private UserCommentDAO userCommentDAO;

	private static final Logger logger = Logger.getLogger(CommentAnalyser.class);
	
	public void processComment(UserComment userComment) 
	{
		List<TokenWords> tokenWords = tokenWordsDAO.getAllWords();

		String comment= userComment.getUserComment();
		//TODO filter
		comment = comment.replaceAll(",", "");
		comment = comment.replaceAll("\\.", "");
		int rating = 0;
		String[] splittComment = comment.split(" ");
		int count=0;
		int weightage=0;
		for (String string : splittComment) 
		{
			for (TokenWords token : tokenWords) 
			{		
				if(string.equalsIgnoreCase(token.getToken())) 
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
			logger.debug("--Log-Debug--Number divided by Zero--");
		}
		
		userComment.setCommentValue(rating);
		userCommentDAO.updateUserComment(userComment);
	}
}