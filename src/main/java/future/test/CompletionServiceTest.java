package future.test;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		for (int i = 1; i < 10; i++) {
			final int taskID = i;
			cs.submit(new Callable<Integer>() {

				public Integer call() throws Exception {
					Thread.sleep(taskID * 1000);
					return taskID;
				}
			});
		}
		// 可能做一些事情
		for (int i = 1; i < 10; i++) {
			System.out.println(cs.poll());
		}
	}
}
