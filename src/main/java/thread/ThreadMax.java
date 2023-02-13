package thread;

/**
 * @author 吕胜 lvheng1
 * @date 2023/2/13
 **/
public class ThreadMax {
	
	public static void main(String[] args) {
		int i = 1;
		while (true) {
			Thread thread = new Thread();
			thread.start();
			System.out.println("thread : " + i);
			i++;
		}
	}
}
