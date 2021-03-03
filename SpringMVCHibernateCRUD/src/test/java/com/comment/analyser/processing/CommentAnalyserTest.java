package com.comment.analyser.processing;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.Test;

import com.comment.analyser.dao.TokenWordDAO;
import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.dao.impl.TokenWordDAOImpl;
import com.comment.analyser.model.TokenWords;
import com.comment.analyser.model.UserComment;

public class CommentAnalyserTest {
	@Mock
	TokenWordDAO tokenWordsDAO;
	
	@Test
	public void testProcessComment() 
	{
		//TokenWordDAO tokenWordsDAO = EasyMock.createMock(TokenWordDAO.class);
		EasyMock.replay(tokenWordsDAO);
		EasyMock.expect(tokenWordsDAO.getAllWords()).andReturn(getTockenWords());
		//EasyMock.replay(tokenWordsDAO);
		UserComment userComment= geUserComment() ;
		UserCommentDAO userCommentDAO = EasyMock.createMock(UserCommentDAO.class);
		EasyMock.expect(userCommentDAO.updateUserComment(userComment)).andReturn(null);
		CommentAnalyser analyzer = new CommentAnalyser();
		analyzer.processComment(userComment);
		System.out.println(userComment.getCommentValue());
	}
	private List<TokenWords> getTockenWords(){
		List<TokenWords> list = new ArrayList<>();
		list.add(getTokenWords("Good",4));
		list.add(getTokenWords("Bad",1));
		list.add(getTokenWords("happy",5));
		return list;
	}
	
	private TokenWords getTokenWords(String tokenStr, int weitage) {
		TokenWords token = new TokenWords();
		token.setToken(tokenStr);
		token.setWeightage(weitage);
		return token;
	}
	
	private UserComment geUserComment() {
		UserComment userComment = new UserComment();
		userComment.setUserComment("I am very happy Today");
		return userComment;
	}
}
