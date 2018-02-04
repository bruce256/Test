package excel;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * sax解析会越过空的cell，因为空的cell根本不会在sheet.xml出现。处理cell时列号要自己存储
 *
 * @auther 儒尊
 * @date 2018-02-05 01:07:34
 **/
public class MyEventUserModel {
	
	private static Pattern COLUMN_A = Pattern.compile("A([\\d]+)");
	
	private List<ParsedRow> sheetData = Lists.newArrayList();
	private ParsedRow       rowData   = new ParsedRow();
	
	public void processOneSheet(String filename) throws Exception {
		OPCPackage         pkg = OPCPackage.open(filename);
		XSSFReader         r   = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();
		
		XMLReader parser = fetchSheetParser(sst);
		
		// To look up the Sheet Name / Sheet Order / rID,
		//  you need to process the core Workbook stream.
		// Normally it's of the form rId# or rSheet#
		InputStream sheet2      = r.getSheet("rId1");
		InputSource sheetSource = new InputSource(sheet2);
		parser.parse(sheetSource);
		sheet2.close();
	}
	
	public void processAllSheets(String filename) throws Exception {
		OPCPackage         pkg = OPCPackage.open(filename);
		XSSFReader         r   = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();
		
		XMLReader parser = fetchSheetParser(sst);
		
		Iterator<InputStream> sheets = r.getSheetsData();
		while (sheets.hasNext()) {
			System.out.println("Processing new sheet:\n");
			InputStream sheet       = sheets.next();
			InputSource sheetSource = new InputSource(sheet);
			parser.parse(sheetSource);
			sheet.close();
			System.out.println("");
		}
	}
	
	public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
		XMLReader parser =
				XMLReaderFactory.createXMLReader(
						"org.apache.xerces.parsers.SAXParser"
				);
		ContentHandler handler = new SheetHandler(sst);
		parser.setContentHandler(handler);
		return parser;
	}
	
	/**
	 * See org.xml.sax.helpers.DefaultHandler javadocs
	 */
	private class SheetHandler extends DefaultHandler {
		
		private SharedStringsTable sst;
		private String             lastContents;
		private boolean            nextIsString;
		private Short              index;
		
		private SheetHandler(SharedStringsTable sst) {
			this.sst = sst;
		}
		
		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			// c => cell
			if (name.equals("c")) {
				// Print the cell reference
				String        coordinate    = attributes.getValue("r");
				CellReference cellReference = new CellReference(coordinate);
				index = cellReference.getCol();
				System.out.print(coordinate + " - ");
				Matcher matcher = COLUMN_A.matcher(coordinate);
				
				// 第一行单独解析行号
				if (matcher.matches() && rowData.getCellMap().isEmpty()) {
					rowData.setRowIndex(Integer.valueOf(matcher.group(1)) - 1);
				}
				
				if (matcher.matches() && !rowData.getCellMap().isEmpty()) {
					sheetData.add(rowData);
					rowData = new ParsedRow();
					rowData.setRowIndex(Integer.valueOf(matcher.group(1)) - 1);
				}
				
				// Figure out if the value is an index in the SST
				String cellType = attributes.getValue("t");
				if (cellType != null && cellType.equals("s")) {
					nextIsString = true;
				} else {
					nextIsString = false;
				}
			}
			// Clear contents cache
			lastContents = "";
		}
		
		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			// Process the last contents as required.
			// Do now, as characters() may be called more than once
			if (nextIsString) {
				int idx = Integer.parseInt(lastContents);
				lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
				nextIsString = false;
			}
			
			// v => contents of a cell
			// Output after we've seen the string contents
			if (name.equals("v")) {
				System.out.println(lastContents);
				rowData.getCellMap().put(index, lastContents);
			}
		}
		
		@Override
		public void endDocument() throws SAXException {
			if (!rowData.getCellMap().isEmpty()) {
				sheetData.add(rowData);
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			lastContents += new String(ch, start, length);
		}
	}
	
	@Data
	private class ParsedRow {
		
		private Integer rowIndex;
		private Map<Short, String> cellMap = Maps.newLinkedHashMap();
	}
	
	public static void main(String[] args) throws Exception {
		String           fileName = "/Users/lvsheng/Downloads/全渠道商品发布模板.xlsx";
		MyEventUserModel example  = new MyEventUserModel();
		example.processOneSheet(fileName);
		//example.processAllSheets(fileName);
		example.sheetData
				.stream()
				.forEach(parsedRow -> System.out.println(JSON.toJSONString(parsedRow)));
	}
}