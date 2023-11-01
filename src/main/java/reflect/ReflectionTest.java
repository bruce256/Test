package reflect;

import com.fasterxml.jackson.annotation.JsonTypeName;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Stopwatch;
import jackson.InputPageModel;
import org.reflections.Reflections;

import java.io.InputStream;
import java.util.Set;

/**
 * @auther 儒尊
 * @date 2018/2/20
 **/
public class ReflectionTest {
	
	public static void main(String[] args) {
		Reflections                       reflections = new Reflections("java.");
		Stopwatch                         stopwatch   = Stopwatch.createStarted();
		Set<Class<? extends InputStream>> allTypes    = reflections.getSubTypesOf(InputStream.class);
		
		Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(JsonTypeName.class);
//		ObjectMapper  mapper   = new ObjectMapper();
//		classSet.parallelStream().forEach(clazz -> mapper.registerSubtypes(clazz));
		System.out.println(stopwatch.toString());
		for (Class type : allTypes) {
			System.out.println(type.getName());
		}
	}
}
