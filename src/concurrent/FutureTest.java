package concurrent;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lvsheng
 *         project TEST
 *         date 2016年2月2日
 *         time 上午10:04:26
 */
public class FutureTest {

	public static void main(String[] args) {
		Callable<Integer> callable = new Callable<Integer>() {

			public Integer call() throws Exception {
				System.out.println("a" + new Date());
				Thread.sleep(5000);// 可能做一些事情

				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try {
			System.out.println("b" + new Date());
			System.out.println(future.get());
			System.out.println("c" + new Date());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}