package thread;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lvsheng
 * @date 2019-01-22
 **/
public class ThreadPool {
	
	@Test
	public void syncTest() {
		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(8);
		System.out.println(new Date());
		for(int i=0; i<10;i++) {
			
			scheduledThreadPoolExecutor.schedule(() -> System.out.println(new Date()), 1, TimeUnit.SECONDS);
		}
		try {
			scheduledThreadPoolExecutor.shutdown();
			scheduledThreadPoolExecutor.awaitTermination(3, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
