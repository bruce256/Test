package arthas;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/3/11
 **/
public class ArthasTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("c");
		list2.add("d");
		
		while (true) {
			add(list, list2);
		}
	}
	
	private static int add(List<String> list, List<String> list2) {
		int i = 10;
		while (i >= 0) {
			try {
				hehe(i);
			} catch (Throwable t) {
				t.printStackTrace();
			}
			i--;
		}
		
		//list.addAll(list2);
		return list.size();
	}
	
	private static void hehe(int i) {
		if (i == 0) {
			//throw new RuntimeException("ZERO");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("arthas");
		}
	}
	
}
