package excel;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
	private StylesTable stylesTable;
	
	public void processOneSheet(String filename) throws Exception {
		OPCPackage         pkg = OPCPackage.open(filename);
		XSSFReader         r   = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();
		stylesTable = r.getStylesTable();
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
		
		Iterator<InputStream>    sheets   = r.getSheetsData();
		XSSFReader.SheetIterator iterator = (XSSFReader.SheetIterator) sheets;
		while (iterator.hasNext()) {
			//System.out.println("Processing new sheet:\n");
			InputStream sheet = iterator.next();
			//System.out.println(iterator.getSheetName());
			InputSource sheetSource = new InputSource(sheet);
			parser.parse(sheetSource);
			sheet.close();
			//System.out.println("");
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
				//System.out.print(coordinate + " - ");
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
				
				this.setNextDataType(attributes);
				
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
			
			//String value = this.getDataValue(lastContents.trim(), "");
			
			// v => contents of a cell
			// Output after we've seen the string contents
			if (name.equals("v")) {
				//System.out.println(lastContents);
				rowData.getCellMap().put(index.intValue(), lastContents);
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
		
		
		/**
		 * 单元格数据类型，默认为字符串类型
		 */
		private CellDataType nextDataType = CellDataType.SSTINDEX;
		
		private final DataFormatter formatter = new DataFormatter();
		
		private short  formatIndex;
		private String formatString;
		
		
		/**
		 * 处理数据类型
		 *
		 * @param attributes
		 */
		public void setNextDataType(Attributes attributes) {
			nextDataType = CellDataType.NUMBER;
			formatIndex = -1;
			formatString = null;
			String cellType     = attributes.getValue("t");
			String cellStyleStr = attributes.getValue("s");
			String columData    = attributes.getValue("r");
			
			if ("b".equals(cellType)) {
				nextDataType = CellDataType.BOOL;
			} else if ("e".equals(cellType)) {
				nextDataType = CellDataType.ERROR;
			} else if ("inlineStr".equals(cellType)) {
				nextDataType = CellDataType.INLINESTR;
			} else if ("s".equals(cellType)) {
				nextDataType = CellDataType.SSTINDEX;
			} else if ("str".equals(cellType)) {
				nextDataType = CellDataType.FORMULA;
			}
			
			if (cellStyleStr != null) {
				int           styleIndex = Integer.parseInt(cellStyleStr);
				XSSFCellStyle style      = stylesTable.getStyleAt(styleIndex);
				formatIndex = style.getDataFormat();
				formatString = style.getDataFormatString();
				
				if ("m/d/yy".equals(formatString) || "m/d/yy h:mm".equals(formatString)) {
					nextDataType = CellDataType.DATE;
					formatString = "yyyy-MM-dd hh:mm:ss.SSS";
				}
				
				if (formatString == null) {
					nextDataType = CellDataType.NULL;
					formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
				}
			}
		}
		
		/**
		 * 对解析出来的数据进行类型处理
		 *
		 * @param value   单元格的值（这时候是一串数字）
		 * @param thisStr 一个空字符串
		 * @return
		 */
		public String getDataValue(String value, String thisStr) {
			switch (nextDataType) {
				// 这几个的顺序不能随便交换，交换了很可能会导致数据错误
				case BOOL:
					char first = value.charAt(0);
					thisStr = first == '0' ? "FALSE" : "TRUE";
					break;
				case ERROR:
					thisStr = "\"ERROR:" + value.toString() + '"';
					break;
				case FORMULA:
					thisStr = '"' + value.toString() + '"';
					break;
				case INLINESTR:
					XSSFRichTextString rtsi = new XSSFRichTextString(value.toString());
					
					thisStr = rtsi.toString();
					rtsi = null;
					break;
				case SSTINDEX:
					String sstIndex = value.toString();
					try {
						int                idx  = Integer.parseInt(sstIndex);
						XSSFRichTextString rtss = new XSSFRichTextString(sst.getEntryAt(idx));
						thisStr = rtss.toString();
						rtss = null;
					} catch (NumberFormatException ex) {
						thisStr = value.toString();
					}
					break;
				case NUMBER:
					if (StringUtils.isEmpty(value)) {
						break;
					}
					
					if (formatString != null) {
						thisStr = formatter.formatRawCellContents(Double.parseDouble(value), formatIndex, formatString).trim();
					} else {
						thisStr = value;
					}
					
					thisStr = thisStr.replace("_", "").trim();
					break;
				case DATE:
					thisStr = formatter.formatRawCellContents(Double.parseDouble(value), formatIndex, formatString);
					
					// 对日期字符串作特殊处理
					thisStr = thisStr.replace(" ", "T");
					break;
				default:
					thisStr = " ";
					
					break;
			}
			
			return thisStr;
		}
	}
	
	/**
	 * 单元格中的数据可能的数据类型
	 */
	enum CellDataType {
		BOOL, ERROR, FORMULA, INLINESTR, SSTINDEX, NUMBER, DATE, NULL
	}
	
	public static void main(String[] args) throws Exception {
		//String           fileName  = "/Users/lvsheng/Downloads/全渠道商品发布模板.xlsx";
		String           fileName  = "/study/excel性能测试/全渠道商品发布模板 - 副本 (12).xlsx";
		MyEventUserModel example   = new MyEventUserModel();
		Stopwatch        stopwatch = Stopwatch.createStarted();
		example.processOneSheet(fileName);
		System.out.println("-----------------finish, " + stopwatch.toString());
		//example.processAllSheets(fileName);
		/*Thread.sleep(100000 * 1000);
		example.sheetData
				.stream()
				.forEach(parsedRow -> System.out.println(JSON.toJSONString(parsedRow)));*/
	}
}