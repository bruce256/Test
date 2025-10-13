package concurrent;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * @auther: LvSheng
 * @date: 2025/10/10
 * @description:
 */
public class ParallelStreamBlockDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);

        System.out.println("CommonPool 并行度: " +
            ForkJoinPool.commonPool().getParallelism());

        // 模拟在 parallelStream 中执行阻塞操作
        numbers.parallelStream().forEach(number -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("开始处理 " + number + " 在线程 " + threadName);

            // 模拟阻塞的 Minio 上传
            try {
                // 这个 CompletableFuture 可能也在 commonPool 执行
                CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(20000); // 模拟网络 I/O
                        return "result-" + number;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

                // 在 commonPool 线程中阻塞等待！
                String result = future.get(); // ← 阻塞点！

                System.out.println("完成处理 " + number + " 结果: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("所有任务提交完成");
    }
}
