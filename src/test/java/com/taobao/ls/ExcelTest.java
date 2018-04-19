package com.taobao.ls;

import com.google.common.collect.Lists;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
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
	public void writeError() {
		XSSFWorkbook wb    = new XSSFWorkbook();
		XSSFSheet    sheet = wb.createSheet("formula");
		XSSFRow      row   = sheet.createRow(0);
		XSSFCell     cell  = row.createCell(0);
		cell.setCellType(CellType.FORMULA);
		cell.setCellValue("formula");
		try {
			FileOutputStream fos = new FileOutputStream("/temp/formula.xlsx");
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void readExcel() {
		try (XSSFWorkbook wb = new XSSFWorkbook("/Users/lvsheng/Downloads/12/全渠道商品发布模板 - 副本 (12).xlsx")) {
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
	
	@Test
	public void writeExcel() {
		try (FileOutputStream fos = new FileOutputStream("/study/excel性能测试/gant-全渠道商品发布模板10000.xlsx");
			 XSSFWorkbook wb = new XSSFWorkbook("/study/excel性能测试/gant-全渠道商品发布模板.xlsx")) {
			XSSFSheet     sheet       = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			List<Row>     list        = Lists.newArrayList(rowIterator);
			Row           cells       = list.get(3);
			short         lastCellNum = cells.getLastCellNum();
			for (int rowIdx = 4; rowIdx < 10000; rowIdx++) {
				XSSFRow row = sheet.createRow(rowIdx);
				for (int columnIdx = 0; columnIdx < lastCellNum; columnIdx++) {
					Cell cell = null;
					try {
						cell = cells.getCell(columnIdx);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (cell != null) {
						XSSFCell rowCell = row.createCell(columnIdx);
						switch (cell.getCellTypeEnum()) {
							case STRING:
								rowCell.setCellValue(cell.getStringCellValue() + rowIdx);
								break;
							case NUMERIC:
								rowCell.setCellValue(cell.getNumericCellValue() + rowIdx);
								break;
							default:
								break;
						}
					}
				}
			}
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeExcel1() {
		try (FileOutputStream fos = new FileOutputStream("/study/excel性能测试/满载.xlsx");
			 XSSFWorkbook wb = new XSSFWorkbook()) {
			XSSFSheet sheet = wb.createSheet();
			for (int r = 0; r < 20 * 10000; r++) {
				XSSFRow row = sheet.createRow(r);
				for (int c = 0; c < 19; c++) {
					XSSFCell cell = row.createCell(c);
					cell.setCellValue("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				}
			}
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void lockSheet() {
		try {
			String       fileName = "/temp/lockSheet.xlsx";
			XSSFWorkbook wb       = new XSSFWorkbook();
			CellStyle    style    = wb.getCellStyleAt(0);
			style.setLocked(false);
			
			
			XSSFSheet xssfSheet = wb.createSheet("儒尊");
			//可编辑的单元格样式
			CellStyle lockedCellStyle = xssfSheet.getWorkbook().createCellStyle();
			lockedCellStyle.setLocked(false);
			
			org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol cTCol = ((XSSFSheet) xssfSheet).getCTWorksheet().getColsArray(0).addNewCol();
			cTCol.setMin(1);
			cTCol.setMax(SpreadsheetVersion.EXCEL2007.getMaxColumns());
			cTCol.setStyle(lockedCellStyle.getIndex());
			xssfSheet.lockFormatCells(true);
			xssfSheet.lockFormatColumns(true);
			xssfSheet.lockFormatRows(true);
			xssfSheet.protectSheet("123456");
			wb.write(new FileOutputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
