// Generated from /work/github/Test/src/main/java/antlr/power.g4 by ANTLR 4.5.3
package antlr.gen.power;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link powerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface powerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link powerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(powerParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Pow}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(powerParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(powerParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link powerParser#express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(powerParser.IntContext ctx);
}