package antlr;

/**
 * @author lvsheng
 * @date 2018/10/5
 **/

import antlr.gen.power.powerLexer;
import antlr.gen.power.powerParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PowerTest {
	
	
	public static void main(String[] args) {
		
		
		ANTLRInputStream  inputStream = new ANTLRInputStream("2^10");
		powerLexer        lexer       = new powerLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		powerParser       parser      = new powerParser(tokenStream);
		ParseTree         parseTree   = parser.prog();
		PowerVisitorImpl  visitor     = new PowerVisitorImpl();
		Long              rtn         = visitor.visit(parseTree);
		System.out.println("#result# = " + rtn.toString());
		
		
	}
	
	
}