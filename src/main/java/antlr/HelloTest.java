package antlr;

/**
 * @author lvsheng
 * @date 2018/10/5
 **/

import antlr.gen.hello.HelloBaseVisitor;
import antlr.gen.hello.HelloLexer;
import antlr.gen.hello.HelloParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class HelloTest {
	
	
	public static void main(String[] args) {
		
		
		/*CodePointCharStream      inputStream = CharStreams.fromString("hello lvsheng\r\n");
		HelloLexer               lexer       = new HelloLexer(inputStream);
		CommonTokenStream        tokenStream = new CommonTokenStream(lexer);
		HelloParser              parser      = new HelloParser(tokenStream);
		ParseTree                parseTree   = parser.prog();
		HelloBaseVisitor<String> visitor     = new HelloBaseVisitor();
		String                   rtn         = visitor.visit(parseTree);
		System.out.println("#result#" + rtn.toString());
		*/
		
	}
	
	
}