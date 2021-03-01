package com.jwt.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableScheduling
@Service
public class SchedulerTask {

	@Scheduled(fixedRate = 10000)
	public void startProcessing() {
		System.out.println("Start processing all unprocessed comments");
	}
}
