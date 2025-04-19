package concurrent;


import net.sf.jsqlparser.expression.operators.relational.OldOracleJoinBinaryExpression;
import org.openjdk.jol.info.ClassLayout;

/**
 * @auther: LvSheng
 * @date: 2025/4/18
 * @description:
 */
public class Synchronized {
    public static void main(String[] args) {
        Object obj = new Object();

        System.out.println(Integer.toHexString(obj.hashCode()));
        System.out.println(obj);
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        // 多线程竞争触发锁升级
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (obj) {
                    System.out.println(ClassLayout.parseInstance(obj).toPrintable());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
