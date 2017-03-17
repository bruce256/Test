package concurrent;

/**
 * @auther lvsheng
 * @date 2016年3月29日
 * @time 下午7:38:24
 * @project TEST
 * 
 */

public class NotifyAllTest {

	public static void main(String[] args) {
		Object lock = new Object();
		ThreadA a = new ThreadA(lock);
		ThreadA a1 = new ThreadA(lock);
		ThreadA a2 = new ThreadA(lock);
		ThreadA a3 = new ThreadA(lock);
		ThreadA a4 = new ThreadA(lock);
		ThreadB b = new ThreadB(lock);
		
		b.start();
		a.start();
		a1.start();
		a2.start();
		a3.start();
		a4.start();
	}
}

class ThreadA extends Thread {

	Object	lock;

	public ThreadA(Object l) {
		this.lock = l;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getClass().getName() + " ends");
	}
}

class ThreadB extends Thread {

	Object	lock;

	public ThreadB(Object l) {
		this.lock = l;
	}

	@Override
	public void run() {

		synchronized (lock) {
			lock.notifyAll();
		}
		System.out.println(this.getClass().getName() + " ends");
	}
}
