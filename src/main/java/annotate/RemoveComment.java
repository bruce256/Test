package annotate;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LvSheng
 * @date 2020/2/25
 **/
public class RemoveComment {
	
	public static final String START = "/*";
	public static final String END   = "*/";
	
	public String removeComments(String sourceCode) {
		if (sourceCode == null || sourceCode.isEmpty()) return null;
		
		StringBuffer result = new StringBuffer(sourceCode.length());
		
		boolean strStart = false;
		for (int i = 0; i < sourceCode.length(); ) {
			
			char c = sourceCode.charAt(i);
			if (c == '"' && !strStart) {
				strStart = true;
			} else if (c == '"' && strStart) {
				strStart = false;
			}
			
			if (i + 1 < sourceCode.length()) {
				char c1 = sourceCode.charAt(i + 1);
				if (c == '/' && c1 == '*' && !strStart) {
					int end = sourceCode.indexOf("*/", i);
					i = end + 2;
					continue;
				}
				
				if (c == '/' && c1 == '/' && !strStart) {
					int end = sourceCode.indexOf("\n", i);
					i = end;
					continue;
				}
			}
			
			result.append(c);
			i++;
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br   = new BufferedReader(new FileReader("/Users/LvSheng/code/github/Test/src/main/java/annotate/TopK.java"));
		StringBuffer   sb   = new StringBuffer();
		String         line = null;
		while ((line = br.readLine()) != null) sb.append(line + "\n");
		
		RemoveComment rc = new RemoveComment();
		System.out.println(rc.removeComments(sb.toString()));
	}
}
