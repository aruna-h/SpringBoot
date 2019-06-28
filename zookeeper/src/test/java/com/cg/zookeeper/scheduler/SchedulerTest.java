/**
 * 
 */
package com.cg.zookeeper.scheduler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author arunbh entity for testing SchedulerTask
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SchedulerTest {
	@InjectMocks
	SchedulerTask scheduledTask;

	/**
	 * testcase for getmessage function
	 */
	@Test
	public void checkgetmessage() {
		scheduledTask.getmessage();
	}

}
