package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @auther lvsheng
 * @date 2016年3月31日
 * @time 下午6:35:15
 * @project TEST
 * 
 */

public class CallableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new Call(i)));
		}
		int sum = 0;
		for (Future<Integer> future : results) {
			try {
				sum += future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println(sum);
	}

}

class Call implements Callable<Integer> {

	int	val;

	public Call(int val) {
		this.val = val;
	}

	@Override
	public Integer call() throws Exception {
		return val;
	}

}
