package antlr.gen.el;

import antlr.gen.el.antlr.ElLexer;
import antlr.gen.el.antlr.ElParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @author lvsheng
 * @date 2019-03-24
 **/
public class ElTest {
	
	public static void main(String[] args) {
		
		
		String input =
				 "a = 3 * 5 + 10;"
				+ "b=40;"
				+ "a * b + 100;";
		ANTLRInputStream  inputStream = new ANTLRInputStream(input);
		ElLexer           lexer       = new ElLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ElParser          parser      = new ElParser(tokenStream);
		ParseTree         parseTree   = parser.program();
		ElVisitorImpl     visitor     = new ElVisitorImpl();
		Double            rtn         = visitor.visit(parseTree);
		System.out.println("#result# = " + rtn.toString());
		
	}
}
