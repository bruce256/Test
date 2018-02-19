package excel;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther 儒尊
 * @date 2018/2/9
 **/
public class XssfWorkBookTest {
	
	public static final int ROW_NUM = 50000;
	public static final int COL_NUM = 10;
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(100 * 1000);
		Stopwatch stopwatch = Stopwatch.createStarted();
		try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
			 FileOutputStream fileOutputStream = new FileOutputStream("/study/excel性能测试/XssfWorkBookTest.xlsx")) {
			XSSFSheet xssfSheet = xssfWorkbook.createSheet("XSSFWorkbook");
			for (int rowIndex = 0; rowIndex < ROW_NUM; rowIndex++) {
				XSSFRow row = xssfSheet.createRow(rowIndex);
				for (int colIdx = 0; colIdx < COL_NUM; colIdx++) {
					XSSFCell cell = row.createCell(colIdx);
					cell.setCellValue(Joiner.on("_").join("XSSFWorkbook", rowIndex, colIdx));
				}
			}
			
			System.out.println("--------finish, " + stopwatch.toString());
			Thread.sleep(100000 * 1000);
			xssfWorkbook.write(fileOutputStream);
			System.out.println("--------finish, " + stopwatch.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
