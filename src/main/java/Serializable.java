import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 儒尊
 * @date 2017/11/18
 **/
public class Serializable {
	@Test
	public void test() {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(1);
		list.add(1);
		List subList = list.subList(0, 1);
		if(subList instanceof java.io.Serializable) {
			System.out.println(subList.getClass().getName() + " implement serializable");
		} else  {
			System.out.println(subList.getClass().getName() + " does not implement serializable");
		}
	}
}
