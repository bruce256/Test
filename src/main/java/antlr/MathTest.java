package antlr;

/**
 * @author lvsheng
 * @date 2018/10/5
 **/

import antlr.gen.math.MathLexer;
import antlr.gen.math.MathParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MathTest {
	
	public static void main(String[] args) {
		//String            simpleInput = " 3 * 4+ 6 / 2\r\n";
		String            sentence    = "a = 5\r\n b = 6\r\n a * b + 3 - ( 5 + 10 )\r\n";
		ANTLRInputStream  inputStream = new ANTLRInputStream(sentence);
		MathLexer         lexer       = new MathLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		MathParser        parser      = new MathParser(tokenStream);
		// 生成解析树
		ParseTree       parseTree = parser.prog();
		MathVisitorImpl visitor   = new MathVisitorImpl();
		// 遍历解析树
		Integer rtn = visitor.visit(parseTree);
		System.out.println("result : " + rtn.toString());
	}
}