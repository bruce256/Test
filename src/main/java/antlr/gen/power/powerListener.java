// Generated from /work/github/Test/src/main/java/antlr/power.g4 by ANTLR 4.5.3
package antlr.gen.power;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link powerParser}.
 */
public interface powerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link powerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(powerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link powerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(powerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 */
	void enterPow(powerParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 */
	void exitPow(powerParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(powerParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(powerParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 */
	void enterInt(powerParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 */
	void exitInt(powerParser.IntContext ctx);
}