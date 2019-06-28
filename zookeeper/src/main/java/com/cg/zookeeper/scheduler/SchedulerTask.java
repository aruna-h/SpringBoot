/**
 * 
 */
package com.cg.zookeeper.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cg.zookeeper.ZookeeperApplication;

/**
 * @author arunbh entity for SchedulerTask which has getmessage implementation
 */
@Component
public class SchedulerTask {
	private static Logger log = LoggerFactory.getLogger(ZookeeperApplication.class.getSimpleName());

	@Value("${name}")
	private String name;

	/**
	 * method to get message
	 */
	public void getmessage() {

		log.info("welcome to capgemini!! " + name);
	}

}
