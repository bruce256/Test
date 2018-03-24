package excel;

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @auther 儒尊
 * @date 2018/3/12
 **/
public class AutoWidth {
	
	private static XSSFCellStyle createHeaderCellStyle(XSSFWorkbook wb) {
		XSSFFont columnHeaderFont = wb.createFont();
		columnHeaderFont.setFamily(FontFamily.ROMAN);
		columnHeaderFont.setFontName("Courier New");
		columnHeaderFont.setFontHeight(18);
		XSSFCellStyle headerStyle = wb.createCellStyle();
		headerStyle.setFont(columnHeaderFont);
		return headerStyle;
	}
	
	public static void main(String[] args) {
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet xssfSheet = workbook.createSheet("autoWidth");
			XSSFRow   row0      = xssfSheet.createRow(0);
			row0.setHeightInPoints(30);
			XSSFCellStyle headerCellStyle = createHeaderCellStyle(workbook);
			for (int colIdx = 0; colIdx < 10; colIdx++) {
				XSSFCell cell = row0.createCell(colIdx);
				cell.setCellValue("abcdefghijklmn" + colIdx);
				cell.setCellStyle(headerCellStyle);
				xssfSheet.autoSizeColumn(colIdx);
			}
			
			CellRangeAddressList regions = new CellRangeAddressList(0, 10, 0, 2);
			//生成下拉框内容
			String[] array = new String[2];
			for (int i = 0; i < array.length; i++) {
				array[i] = i + "abcdefghijklmnopqrstuvwxyz1234567890";
			}
			XSSFDataValidationHelper     dvHelper     = new XSSFDataValidationHelper(xssfSheet);
			XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper.createExplicitListConstraint(array);
			//绑定下拉框和作用区域
			DataValidation validation = dvHelper.createValidation(dvConstraint, regions);
			//对sheet页生效
			xssfSheet.addValidationData(validation);
			workbook.write(new FileOutputStream(new File("/temp/autoWidth.xlsx")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
