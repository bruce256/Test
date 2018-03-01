package classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther 儒尊
 * @date 2018/3/1
 **/
public class MyClassLoader {
	
	public static void main(String[] args) throws Exception {
		
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String      fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is       = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		Object obj = myLoader.loadClass("classloader.MyClassLoader").newInstance();
		
		MyClassLoader myClassLoader = new MyClassLoader();
		
		System.out.println(obj.getClass());
		System.out.println(obj instanceof classloader.MyClassLoader);
		System.out.println(myClassLoader.equals(obj));
	}
}
