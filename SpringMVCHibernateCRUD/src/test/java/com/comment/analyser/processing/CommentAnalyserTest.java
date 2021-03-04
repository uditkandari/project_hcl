package com.comment.analyser.processing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.comment.analyser.dao.TokenWordDAO;
import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.TokenWords;
import com.comment.analyser.model.UserComment;

@RunWith(MockitoJUnitRunner.class)
public class CommentAnalyserTest {
	
	@Mock
	TokenWordDAO tokenWordsDAO;
	
	@Mock
	UserCommentDAO userCommentDAO;

	@InjectMocks
	CommentAnalyser analyzer;
	
	@Test
	public void testProcessComment() 
	{
		UserComment userComment= geUserComment() ;
		Mockito.when(tokenWordsDAO.getAllWords()).thenReturn(getTockenWords());
		Mockito.when(userCommentDAO.updateUserComment(userComment)).thenReturn(userComment);
		analyzer.processComment(userComment);
		assertEquals(4, userComment.getCommentValue());
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
		userComment.setUserComment("I am very Good Today");
		return userComment;
	}
}
