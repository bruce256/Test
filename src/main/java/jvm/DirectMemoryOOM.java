package jvm;


import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxDirectMemorySize=1g
 *
 * @auther: LvSheng
 * @date: 2024/12/10
 * @description:
 */
public class DirectMemoryOOM {
    public static void main(String[] args) {
        List<ByteBuffer> byteBuffers = new ArrayList<>();
        while (true) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1 * 1024);
            byteBuffers.add(byteBuffer);
/*            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
