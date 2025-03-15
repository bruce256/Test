package thread;

/**
 * @author 吕胜 lvheng1
 * @date 2023/2/13
 **/
public class ThreadOOM {

    public static void main(String[] args) {
        int i = 1;
        while (i < 3000) {
            Thread thread = new TestThread();
            thread.start();
            System.out.println("thread : " + i);
            i++;
        }
    }
}


class TestThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
