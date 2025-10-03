package cache;


/**
 * 高速缓存对程序的影响
 * mac m2max的cache line size是128
 * intel的64位芯片的cache line size 一般是64
 *
 * @auther: LvSheng
 * @date: 2025/10/3
 * @description:
 */
public class CacheTest {
    public static void main(String[] args) {
        int[] arr = new int[120 * 1024 * 1024];


        // 循环1
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) arr[i] *= 3;
        System.out.println("循环一耗时： " + (System.currentTimeMillis() - start) + " ms");

        // 循环2
        start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i += 16) arr[i] *= 3;
        System.out.println("循环二耗时： " + (System.currentTimeMillis() - start) + " ms");
    }
}
