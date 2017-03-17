package nio;  
  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
  
public class NioTest {  
  
	public static void copyContrast() {
		String infile = "G:\\eclipse-jee-luna-SR2-win32.zip";  
        String outfile = "G:\\a.zip";  
        String outfile2 = "G:\\a1.zip";  
          
        long start = System.currentTimeMillis();  
        long end1 = start, end2 = start;
        try {
        	normalCopy(infile, outfile2);  
	        end2 = System.currentTimeMillis(); 
			nioCopy(infile, outfile);
			end1 = System.currentTimeMillis();  
		} catch (Exception e) {
			e.printStackTrace();
		}  
        
        System.out.println("normal copy lasts: " + (end2 - start) + " ms.");
        System.out.println("nio copy lasts: " + (end1 - end2) + " ms.");  
        
        new File(outfile).delete();
        new File(outfile2).delete();
	}
    /** 
     * test 
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
        FileInputStream fin = new FileInputStream(infile);  
        FileOutputStream fout = new FileOutputStream(outfile);  
        FileChannel fcin = fin.getChannel();  
        FileChannel fcout = fout.getChannel();  
//        ByteBuffer buffer = ByteBuffer.allocate(1024);  
          
//        while (true) {  
//            buffer.clear();  
//            int r = fcin.read(buffer);  
//            if (r == -1) {  
//                break;  
//            }  
//            buffer.flip();  
//            fcout.write(buffer);  
//        }  
        fcin.transferTo(0, new File(infile).length(), fcout);
          
        fcin.close();  
        fcout.close();  
        fin.close();  
        fout.close();  
    }  
      
    //普通I/O文件复制功能  
    public static void normalCopy(String infile, String outfile) throws Exception{  
        FileInputStream fin = new FileInputStream(infile);  
        FileOutputStream fout = new FileOutputStream(outfile);  
        byte[] block = new byte[1024];  
        while(fin.read(block) != -1) {  
            fout.write(block);  
        }  
        fin.close();  
        fout.close();  
    }  
  
}  
