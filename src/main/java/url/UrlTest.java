package url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author lvsheng
 * @date 2018/5/15
 **/
public class UrlTest {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("file:/work/dev_tools/zookeeper-3.4.9.tar.gz");
			System.out.println(url.getFile());
			System.out.println(url.getHost());
			System.out.println(url.getProtocol());
			System.out.println(url.getPath());
			System.out.println(url.getPort());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
