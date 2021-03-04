package com.comment.analyser.processing;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comment.analyser.dao.TokenWordDAO;
import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.TokenWords;
import com.comment.analyser.model.UserComment;

/**
 * This class have logic to analyze the comment and calculate the rating
 * 
 * @author udit.kandari
 *
 */
@Service
public class CommentAnalyser
{

	@Autowired
	TokenWordDAO tokenWordsDAO;

	@Autowired
	private UserCommentDAO userCommentDAO;

	private static final Logger logger = Logger.getLogger(CommentAnalyser.class);

	/*
	 * This method receive a comment and analyze it by validating the tokens rating in token data base 
	 * and finally update the customer rating in object itself and save it in DB 
	 */
	public void processComment(UserComment userComment) 
	{
		logger.debug("Started processing comment with id "+ userComment.getId());
		
		List<TokenWords> tokenWords = tokenWordsDAO.getAllWords();

		String comment= userComment.getUserComment();
		//not considering comma and dot, this is because if it suffix with any token that then token
		//will not be matched with one store in DB
		//for example comment "Todays weather is very good, but air quality is worse.", so here while 
		//tokenizing comment "good," will be one token whereas it should be "good", same for "worse."
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
		if(count ==0) {
			rating=1;
			logger.debug("Did not found any token anainst the toke database so setting the default rating ="+rating);
		}else {
			rating = weightage/count;
			logger.info("Rating for comment_id "+userComment.getId()+" was calculated ="+rating);
		}
		userComment.setCommentValue(rating);
		userCommentDAO.updateUserComment(userComment);
	}
}