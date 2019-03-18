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
	 * labeled alternative in {@link powerParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPow(powerParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link powerParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPow(powerParser.PowContext ctx);
}