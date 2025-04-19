package jol;


import org.openjdk.jol.info.ClassLayout;

/**
 * @auther: LvSheng
 * @date: 2025/4/19
 * @description:
 */
public class JolTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        System.out.println(Integer.toHexString(obj.hashCode()));
        System.out.println(obj);
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.gc();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
