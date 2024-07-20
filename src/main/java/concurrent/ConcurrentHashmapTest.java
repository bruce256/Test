package concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: LvSheng
 * @date: 2024/7/6
 * @description:
 */
public class ConcurrentHashmapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        for(int i=0; i<100; i++) {
            map.put(i, i);
        }
    }
}
