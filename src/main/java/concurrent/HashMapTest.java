package concurrent;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * hashmap在并发情况下的问题
 * 1，扩容时，并发读数据可能读不到
 * 2. 并发写数据可能会丢失
 *
 * @auther: LvSheng
 * @date: 2024/6/18
 * @description:
 */
public class HashMapTest {

    public static volatile int missingCount = 0;

    public static void main(String[] args) {
        HashMap<Integer, Integer> map      = new HashMap<>();
        int                       coreSize = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor es = new ThreadPoolExecutor(coreSize, coreSize, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

        int max            = 10000000;
        int testMissingKey = 10001;
        map.put(testMissingKey, 0);
        for (int i = 1; i < max; i++) {
            int finalI = i;
            es.submit(() -> {
                System.out.println(finalI);
                map.put(finalI, finalI);
                Integer value = map.get(testMissingKey);
                if (value == null) {
                    missingCount++;
                }
            });
        }

        try {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println((max - map.size()) + "个数字缺失了");
        System.out.println(missingCount + "次并发读失败");
    }
}
