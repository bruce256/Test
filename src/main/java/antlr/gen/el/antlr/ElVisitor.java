// Generated from /work/github/Test/src/main/java/antlr/gen/el/El.g4 by ANTLR 4.5.3
package antlr.gen.el.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ElParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ElVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ElParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ElParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(ElParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Divide}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivide(ElParser.DivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(ElParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply(ElParser.MultiplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtract}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtract(ElParser.SubtractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ElParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(ElParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ElParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ElParser.AssignContext ctx);
}