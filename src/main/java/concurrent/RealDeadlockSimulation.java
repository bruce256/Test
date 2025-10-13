package concurrent;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @auther: LvSheng
 * @date: 2025/10/12
 * @description:
 */
public class RealDeadlockSimulation {
    public static void main(String[] args) {
        // 创建远大于并行度的任务数量
        List<Integer> numbers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        System.out.println("CPU核心数: " + Runtime.getRuntime().availableProcessors());
        System.out.println("CommonPool 并行度: " +
            ForkJoinPool.commonPool().getParallelism());
        System.out.println("任务数量: " + numbers.size());

        // 模拟生产环境的持续负载
        for (int i = 0; i < 3; i++) {
            System.out.println("=== 第 " + (i + 1) + " 轮执行 ===");

            numbers.parallelStream().forEach(number -> {
                System.out.println("处理 " + number + " - 线程: " +
                    Thread.currentThread().getName());

                // 使用和MinioClient相同的模式
                CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    System.out.println("异步任务执行 - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000); // 模拟网络IO
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "result-" + number;
                });

                try {
                    // 这里会发生死锁！
                    String result = future.get();
                    System.out.println("完成: " + number + " - " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("程序结束");
    }
}
