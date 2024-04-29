package concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

/**
 * @author LvSheng
 * @date 2024/3/23
 **/
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        queue.offer(1);
        System.out.println(queue.size());
        System.out.println("end");

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
        for(int i=0; i<100; i++) {
            map.put(i, i);
        }
    }
}
