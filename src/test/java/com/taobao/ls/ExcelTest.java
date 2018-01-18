package com.taobao.ls;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther 儒尊
 * @date 2018/1/18
 **/
public class ExcelTest {
	
	@Test
	public void autoFilter() {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet    sheet = wb.createSheet("filter");
		CellRangeAddress cra = CellRangeAddress.valueOf("A1");
		sheet.setAutoFilter(cra);
		try {
			FileOutputStream fos = new FileOutputStream("/temp/filter.xlsx");
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
