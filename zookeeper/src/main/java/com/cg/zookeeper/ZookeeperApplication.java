package com.cg.zookeeper;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.cg.zookeeper.scheduler.SchedulerTask;

/**
 * @author arunbh entity of ZookeeperApplication acting as a scheduler with
 *         retrieving message
 */
@SpringBootApplication
@EnableScheduling
public class ZookeeperApplication {
	@Autowired
	SchedulerTask scheduledTask;
	private static Logger log = LoggerFactory.getLogger(ZookeeperApplication.class.getSimpleName());

	public static void main(String[] args) {
		log.info("inside main method");
		SpringApplication.run(ZookeeperApplication.class, args);
		log.info("exiting main method");
	}

	/**
	 * method to retrieve the message with fixed delay of 10 millisecond
	 */
	@Scheduled(fixedDelay = 10)
	public void retrievmsg() {
		scheduledTask.getmessage();
	}

}
