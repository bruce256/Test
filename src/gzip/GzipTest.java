package gzip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * 
 * @auther lvsheng
 * @date 2015年12月2日
 * @time 上午10:14:03
 * @project TEST
 *
 */

public class GzipTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(new File("e:/a.txt")));
	}

}
