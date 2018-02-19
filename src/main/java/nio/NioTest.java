package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NioTest {
	
	public static void copyContrast() {
		String infile   = "/Users/lvsheng/Movies/[电影天堂www.dy2018.com]羞羞的铁拳HD高清国语中英双字.mkv";
		String outfile  = "/Users/lvsheng/Movies/a.mkv";
		String outfile2 = "/Users/lvsheng/Movies/b.mkv";
		
		long start = System.currentTimeMillis();
		long end1  = start, end2 = start;
		try {
			nioCopy(infile, outfile);
			end1 = System.currentTimeMillis();
			normalCopy(infile, outfile2);
			end2 = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("nio copy lasts: " + (end1 - start) + " ms.");
		System.out.println("normal copy lasts: " + (end2 - end1) + " ms.");
		
		new File(outfile).delete();
		new File(outfile2).delete();
	}
	
	/**
	 * test
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		copyContrast();
		copyContrast();
		copyContrast();
	}
	
	//nio文件复制功能
	public static void nioCopy(String infile, String outfile) throws Exception {
		try (FileInputStream fin = new FileInputStream(infile);
			 FileOutputStream fout = new FileOutputStream(outfile);
			 FileChannel fcin = fin.getChannel();
			 FileChannel fcout = fout.getChannel()) {
			
			fcin.transferTo(0, new File(infile).length(), fcout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//普通I/O文件复制功能
	public static void normalCopy(String infile, String outfile) throws Exception {
		try (FileInputStream fin = new FileInputStream(infile);
			 FileOutputStream fout = new FileOutputStream(outfile)) {
			
			byte[] block = new byte[1024];
			while (fin.read(block) != -1) {
				fout.write(block);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}  
