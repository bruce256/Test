import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther lvsheng
 * @date 2016年4月13日
 * @time 上午11:34:14
 * @project TEST
 * 
 */

public class IteratorTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(18);
		for (int i = 0; i < 18; i++)
			list.add(i);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			if(next == 10 || next == 16) {
				iterator.remove();
			}
			//System.out.println(next);
		}
		
		iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			System.out.println(next);
		}
	}

}
