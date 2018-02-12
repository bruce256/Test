package excel;

import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/2/5
 **/
public class MyUserModel {
	
	private List<ParsedRow> sheetData = Lists.newArrayList();
	
	public void readExcel() {
		try (XSSFWorkbook wb = new XSSFWorkbook("/study/excel性能测试/全渠道商品发布模板 - 副本 (12).xlsx")) {
			XSSFSheet     sheet       = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			List<Row>     list        = Lists.newArrayList(rowIterator);
			for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {
				ParsedRow parsedRow = new ParsedRow();
				parsedRow.setRowIndex(rowIndex);
				Row            row          = list.get(rowIndex);
				Iterator<Cell> cellIterator = row.cellIterator();
				List<Cell>     cellList     = Lists.newArrayList(cellIterator);
				for (Cell cell : cellList) {
					parsedRow.getCellMap().put(cell.getColumnIndex(), cell.toString());
				}
				sheetData.add(parsedRow);
			}
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
	
	public static void main(String[] args) {
		MyUserModel myUserModel = new MyUserModel();
		myUserModel.readExcel();
	}
}
