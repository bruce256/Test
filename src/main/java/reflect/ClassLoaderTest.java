package reflect;

/**
 * @auther 儒尊
 * @date 2018/2/23
 **/
public class ClassLoaderTest {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader());
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		ClassLoader parent      = classLoader.getParent();
		System.out.println(parent);
		ClassLoader grandfather = parent.getParent();
		System.out.println(grandfather);
		
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println("java.class.path--------------");
		System.out.println(System.getProperty("java.class.path"));
	}
}
