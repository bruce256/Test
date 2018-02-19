package jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/2/17
 **/
public class MetaSpaceOomMock {
	public static void main(String[] args) {
		URL               url             = null;
		List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
		try {
			url = new File("/temp").toURI().toURL();
			URL[] urls = {url};
			while (true){
				ClassLoader loader = new URLClassLoader(urls);
				classLoaderList.add(loader);
				loader.loadClass("jvm.MetaSpaceOomMock");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
