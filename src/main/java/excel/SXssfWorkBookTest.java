package excel;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther 儒尊
 * @date 2018/2/9
 **/
public class SXssfWorkBookTest {
	
	public static final int ROW_NUM = 50000;
	public static final int COL_NUM = 10;
	
	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		try (SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(100);
			 FileOutputStream fileOutputStream = new FileOutputStream("/temp/SXssfWorkBookTest.xlsx");) {
			
			SXSSFSheet sxssfSheet = sxssfWorkbook.createSheet("SXSSFWorkbook");
			for (int rowIndex = 0; rowIndex < ROW_NUM; rowIndex++) {
				SXSSFRow row = sxssfSheet.createRow(rowIndex);
				for (int colIdx = 0; colIdx < COL_NUM; colIdx++) {
					SXSSFCell cell = row.createCell(colIdx);
					cell.setCellValue(Joiner.on("_").join("SXSSFWorkbook", rowIndex, colIdx));
				}
			}
			
			System.out.println("--------finish, " + stopwatch.toString());
//			Thread.sleep(100000 * 1000);
			
			sxssfWorkbook.write(fileOutputStream);
			//stopwatch.stop();
			sxssfWorkbook.dispose();
			System.out.println("--------finish, " + stopwatch.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
