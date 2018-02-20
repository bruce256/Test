package reflect;

import org.apache.poi.ss.usermodel.Workbook;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @auther 儒尊
 * @date 2018/2/20
 **/
public class ReflectionTest {
	
	public static void main(String[] args) {
		Reflections                    reflections = new Reflections("org.");
		Set<Class<? extends Workbook>> allTypes    = reflections.getSubTypesOf(Workbook.class);
		for (Class type : allTypes) {
			System.out.println(type.getName());
		}
	}
}
