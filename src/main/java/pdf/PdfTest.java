package pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lvsheng
 * @date 2018/12/16
 **/
public class PdfTest {
	
	public static void main(String[] args) {
		
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try (FileOutputStream fos = new FileOutputStream("/temp/pdf/test.pdf")) {
			ITextRenderer renderer = new ITextRenderer();
			File          file     = new File(contextClassLoader.getResource("pdf.html").getPath());
			renderer.setDocument(file);
			renderer.layout();
			
			ITextFontResolver fontResolver = renderer.getFontResolver();
			fontResolver.addFont(contextClassLoader.getResource("simsun.ttc").getPath(),
								 BaseFont.IDENTITY_H,
								 BaseFont.NOT_EMBEDDED);
			renderer.createPDF(fos);
			renderer.finishPDF();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
