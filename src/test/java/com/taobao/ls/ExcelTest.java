package com.taobao.ls;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/1/18
 **/
public class ExcelTest {
	
	@Test
	public void autoFilter() {
		XSSFWorkbook     wb    = new XSSFWorkbook();
		XSSFSheet        sheet = wb.createSheet("filter");
		CellRangeAddress cra   = CellRangeAddress.valueOf("A1");
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
	
	@Test
	public void readExcel() {
		try (XSSFWorkbook wb = new XSSFWorkbook("/Users/lvsheng/Downloads/paytm update 4 AK.xlsx")) {
			XSSFSheet     sheet       = wb.getSheetAt(1);
			Iterator<Row> rowIterator = sheet.rowIterator();
			List<Row>     list        = Lists.newArrayList(rowIterator);
			Thread.sleep(100000 * 1000);
			list.stream().forEach(row -> {
				short firstCellNum = row.getFirstCellNum();
				Cell  cell         = row.getCell(firstCellNum);
				System.out.println(cell.toString());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
