package excel;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/4/19
 **/
public class ReadAndWrite {
	
	private List<ParsedRow> sheetData = Lists.newArrayList();
	
	public void readExcel() {
		try {
//			XSSFWorkbook wb = new XSSFWorkbook("/study/excel性能测试/gant-全渠道商品发布模板(2).xlsx");
			XSSFWorkbook  wb           = new XSSFWorkbook("/Users/lvsheng/Downloads/全渠道商品发布模板 (1).xlsx");
			XSSFWorkbook  errorWb      = new XSSFWorkbook();
			XSSFSheet     sheet        = wb.getSheetAt(0);
			XSSFSheet     errorWbSheet = errorWb.createSheet();
			Iterator<Row> rowIterator  = sheet.rowIterator();
			List<Row>     list         = Lists.newArrayList(rowIterator);
			for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {
				ParsedRow parsedRow = new ParsedRow();
				parsedRow.setRowIndex(rowIndex);
				Row            row             = list.get(rowIndex);
				Iterator<Cell> cellIterator    = row.cellIterator();
				List<Cell>     cellList        = Lists.newArrayList(cellIterator);
				XSSFRow        errorWbSheetRow = errorWbSheet.createRow(rowIndex);
				for (Cell cell : cellList) {
					parsedRow.getCellMap().put(cell.getColumnIndex(), cell.toString());
					XSSFCell errorWbSheetRowCell = errorWbSheetRow.createCell(cell.getColumnIndex());
					errorWbSheetRowCell.setCellType(cell.getCellTypeEnum());
					errorWbSheetRowCell.setCellValue(cell.toString());
				}
				sheetData.add(parsedRow);
			}
			errorWb.write(new FileOutputStream("/temp/aaaa.xlsx"));
			Thread.sleep(10000000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReadAndWrite readAndWrite = new ReadAndWrite();
		Stopwatch   stopwatch   = Stopwatch.createStarted();
		readAndWrite.readExcel();
		System.out.println("-----------------finish, " + stopwatch.toString());
	}
}
