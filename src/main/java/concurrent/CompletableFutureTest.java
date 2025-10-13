package concurrent;



import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LvSheng
 * @date 2024/3/6
 **/
public class CompletableFutureTest {
    public static void main(String[] args) {
        int coreSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, coreSize, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

        CompletableFuture.runAsync(() -> {
            CompletableFuture.runAsync(() -> {
                // 模拟minnio的putObject里的CompletableFuture
                System.out.println(Thread.currentThread().getName());
                System.out.println("hello");
            });
        }, threadPoolExecutor);
    }
}
