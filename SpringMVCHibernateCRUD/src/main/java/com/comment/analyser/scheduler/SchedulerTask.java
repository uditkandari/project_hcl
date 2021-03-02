package com.comment.analyser.scheduler;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comment.analyser.dao.UserCommentDAO;
import com.comment.analyser.model.UserComment;
import com.comment.analyser.processing.CommentAnalyser;

@EnableScheduling
@Service
public class SchedulerTask {
	@Autowired
	private UserCommentDAO userCommentDAO;

	@Autowired
	private CommentAnalyser commentAnalyser;
	
	private static final Logger logger = Logger.getLogger(SchedulerTask.class);

	@Scheduled(fixedRate = 30000)
	public void startProcessing() {
		logger.debug("Start processing all unprocessed comments");
		// get all unprocessed data
		// in for loop call the
		List<UserComment> unprocessedData = userCommentDAO.getUnprocessedComments();

		for (UserComment userComment : unprocessedData) {
			commentAnalyser.processComment(userComment);
		}
		logger.debug("processed all unprocessed records....");
	}
}
