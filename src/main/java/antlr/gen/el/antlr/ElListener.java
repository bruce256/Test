// Generated from /work/github/Test/src/main/java/antlr/gen/el/El.g4 by ANTLR 4.5.3
package antlr.gen.el.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ElParser}.
 */
public interface ElListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ElParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ElParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ElParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ElParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ElParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ElParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDivide(ElParser.DivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDivide(ElParser.DivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNum(ElParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNum(ElParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(ElParser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(ElParser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSubtract(ElParser.SubtractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSubtract(ElParser.SubtractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterId(ElParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitId(ElParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(ElParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(ElParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ElParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ElParser.AssignContext ctx);
}