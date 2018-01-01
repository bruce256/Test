package excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther 儒尊
 * @date 2018/1/1
 **/
public class ExcelDefaultCellStyle {
	
	public static void main(String[] args) {
		try {
			
			Workbook wb = new XSSFWorkbook();
			
			Font font = wb.getFontAt((short) 0);
			font.setFontHeightInPoints((short) 24);
			font.setFontName("Courier New");
			((XSSFFont) font).setFamily(3);
			((XSSFFont) font).setScheme(FontScheme.NONE);
			font.setItalic(true);
			font.setBold(true);
			
			CellStyle style = wb.getCellStyleAt(0);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setWrapText(true);
			
			//((XSSFWorkbook) wb).getStylesSource().getCTStylesheet().addNewCellStyles().addNewCellStyle().setXfId(0);
			
			/*((XSSFCellStyle) style).getStyleXf()
								   .getAlignment()
								   .setVertical(org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignment.CENTER);*/
			//((XSSFCellStyle) style).getStyleXf().getAlignment().setWrapText(true);
			
			Sheet sheet = wb.createSheet();
			
			Row  row  = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("test");
			
			FileOutputStream os = new FileOutputStream("/temp/defaultCell/ExcelDefaultCellStyle1.xlsx");
			wb.write(os);
			os.close();
			
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
}
