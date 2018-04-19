package excel;

import com.google.common.base.Stopwatch;
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
		try {
//			XSSFWorkbook wb = new XSSFWorkbook("/study/excel性能测试/gant-全渠道商品发布模板(2).xlsx");
			XSSFWorkbook  wb          = new XSSFWorkbook("/Users/lvsheng/Downloads/相同类目关键属相相同不同销售属性错误信息汇总.xlsx");
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
			Thread.sleep(10000000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyUserModel myUserModel = new MyUserModel();
		Stopwatch   stopwatch   = Stopwatch.createStarted();
		myUserModel.readExcel();
		System.out.println("-----------------finish, " + stopwatch.toString());
	}
}
