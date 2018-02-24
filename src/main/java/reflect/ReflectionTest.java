package reflect;

import com.google.common.base.Stopwatch;
import org.apache.poi.ss.usermodel.Sheet;
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
		Stopwatch                      stopwatch   = Stopwatch.createStarted();
		Set<Class<? extends Sheet>> allTypes    = reflections.getSubTypesOf(Sheet.class);
		System.out.println(stopwatch.toString());
		for (Class type : allTypes) {
			System.out.println(type.getName());
		}
	}
}
