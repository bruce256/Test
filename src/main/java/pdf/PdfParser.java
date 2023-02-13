package pdf;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LvSheng
 * @date 2023/1/29
 **/
public class PdfParser {
	
	public static void main(String[] args) {
		try {
			PDFParser parser = new PDFParser(new RandomAccessFile(new File("/Users/LvSheng/work/全文标明引文_成都汽车动力电池回收利用政策执行问题及对策研究.pdf"), "r"));
			parser.parse();
			PDDocument      document = parser.getPDDocument();
			for (PDPage page : document.getPages()) {
				InputStream    inputStream = page.getContents();
				String         string           = IOUtils.toString(inputStream, "utf-8");
				System.out.println(string);
			}

//			PDFTextStripper stripper = new PDFTextStripper();
//			String          result   = stripper.getText(document);
//			System.out.println(result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
