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
		
		
		ANTLRInputStream  inputStream = new ANTLRInputStream(" 3 * 4+ 6 / 2\r\n");
		MathLexer         lexer       = new MathLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		MathParser        parser      = new MathParser(tokenStream);
		ParseTree         parseTree   = parser.prog();
		MathVisitorImpl   visitor     = new MathVisitorImpl();
		Integer           rtn         = visitor.visit(parseTree);
		System.out.println("#result# = " + rtn.toString());
		
		
	}
	
	
}