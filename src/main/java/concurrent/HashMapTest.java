package concurrent;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * hashmap在并发情况下的问题
 *
 * @auther: LvSheng
 * @date: 2024/6/18
 * @description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map      = new HashMap<>();
        int                       coreSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor es = new ThreadPoolExecutor(coreSize, coreSize, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

        int max = 10000000;
        for (int i = 0; i < max; i++) {
            int finalI = i;
            es.submit(() -> {
                System.out.println(finalI);
                map.put(finalI, finalI);
            });
        }

        try {
            es.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println((max - map.size()) + "个数字缺失了");
    }
}
