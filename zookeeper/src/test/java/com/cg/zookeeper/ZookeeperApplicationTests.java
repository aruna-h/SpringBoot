package com.cg.zookeeper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.zookeeper.scheduler.SchedulerTask;

/**
 * @author arunbh entity testing the main zookeeper application
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZookeeperApplication.class)
public class ZookeeperApplicationTests {
	@InjectMocks
	ZookeeperApplication zookeeperApplication;
	@Mock
	SchedulerTask scheduledTask;

	@Test
	public void contextLoads() {
	}

	/**
	 * testcase for main method
	 */
	@Test
	public void main() {
		ZookeeperApplication.main(new String[] {});
	}

	/**
	 * testcase for retrievmsg method
	 */
	@Test
	public void checkretrievmsg() {
		zookeeperApplication.retrievmsg();
	}

}
