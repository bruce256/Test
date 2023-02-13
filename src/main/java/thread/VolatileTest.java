package thread;

/**
 * @author LvSheng
 * @date 2022/9/25
 **/
public class VolatileTest {
    public static final int CNT = 1000000000;
    private             int a;
    private volatile    int b;

    public void visitA() {
        for (int i = 0; i < CNT; i++) {
            a = i;
        }
    }

    public void visitB() {
        for (int i = 0; i < CNT; i++) {
            b = i;
        }
    }

    public static void main(String[] args) {
        VolatileTest vt    = new VolatileTest();
        long         start = System.currentTimeMillis();
        vt.visitA();
        long duration = System.currentTimeMillis() - start;
        System.out.println("no volatile duration : " + duration);

        start = System.currentTimeMillis();
        vt.visitB();
        duration = System.currentTimeMillis() - start;
        System.out.println("volatile duration : " + duration);
    }
}
