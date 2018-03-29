package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @auther 儒尊
 * @date 2018/3/29
 **/
public class ZipInputTest {
	
	public static void main(String[] args) {
		Pattern sheetNamePattern = Pattern.compile(".*sheet\\d+\\.xml$");
		File file = new File("/study/excel性能测试/gant-全渠道商品发布模板10000.xlsx");
		try (ZipFile zipFile = new ZipFile(file);
			 FileInputStream fileInputStream = new FileInputStream(file);
			 ZipInputStream zis = new ZipInputStream(fileInputStream)) {
			ZipEntry nextEntry = null;
			while ((nextEntry = zis.getNextEntry()) != null) {
				if(sheetNamePattern.matcher(nextEntry.getName()).matches()) {
					System.out.print(nextEntry.getName() + '\t');
					InputStream zipFileInputStream = zipFile.getInputStream(nextEntry);
					System.out.println(zipFileInputStream.available());
					zipFileInputStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
