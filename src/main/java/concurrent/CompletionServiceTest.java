package concurrent;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther: LvSheng
 * @date: 2025/10/13
 * @description:
 */
public class CompletionServiceTest {

    public static void main(String[] args) {
        // 创建线程池
        int coreSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(coreSize, coreSize, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());

        // 创建CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(threadPoolExecutor);
        // 用于保存Future对象
        List<Future<Integer>> futures = new ArrayList<>(3);

        futures.add(cs.submit(() -> {
            Thread.sleep(30_000);
            System.out.println(3);
            return 3;
        }));

        futures.add(cs.submit(() -> {
            Thread.sleep(20_000);
            System.out.println(2);
            return 2;
        }));


        //提交异步任务，并保存future到futures
        futures.add(cs.submit(() -> {
            Thread.sleep(10_000);
            System.out.println(1);
            return 1;
        }));



        // 获取最快返回的任务执行结果
        Integer r = 0;
        try {
            // 只要有一个成功返回，则break
            for (int i = 0; i < 3; ++i) {
                r = cs.take().get();
                System.out.println(r + " end.");
                //简单地通过判空来检查是否成功返回
            }
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //取消所有任务
            for (Future<Integer> f : futures)
                f.cancel(true);
        }
        // 返回结果
    }
}
