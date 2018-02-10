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
	
	public static void main(String[] args) {
		Stopwatch    stopwatch    = Stopwatch.createStarted();
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet    xssfSheet    = xssfWorkbook.createSheet("XSSFWorkbook");
		for (int rowIndex = 0; rowIndex < ROW_NUM; rowIndex++) {
			XSSFRow row = xssfSheet.createRow(rowIndex);
			for (int colIdx = 0; colIdx < COL_NUM; colIdx++) {
				XSSFCell cell = row.createCell(colIdx);
				cell.setCellValue(Joiner.on("_").join("XSSFWorkbook", rowIndex, colIdx));
			}
		}
		
		try {
			//stopwatch.stop();
			System.out.println("--------finish, " + stopwatch.toString());
			//Thread.sleep(100000 * 1000);
			xssfWorkbook.write(new FileOutputStream("/temp/XssfWorkBookTest.xlsx"));
			xssfWorkbook.close();
			System.out.println("--------finish, " + stopwatch.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
