package antlr.gen.el;

import antlr.gen.el.antlr.ElBaseVisitor;
import antlr.gen.el.antlr.ElParser;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author lvsheng
 * @date 2019-03-23
 **/
public class ElVisitorImpl extends ElBaseVisitor<Double> {
	
	private Map<String, Double> context = Maps.newHashMap();
	
	@Override
	public Double visitProgram(ElParser.ProgramContext ctx) {
		Double result = null;
		for (int i = 0; i < ctx.stat().size(); i++) {
			result = visit(ctx.stat().get(i));
		}
		return result;
	}
	
	@Override
	public Double visitAdd(ElParser.AddContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left + right;
	}
	
	@Override
	public Double visitDivide(ElParser.DivideContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left / right;
	}
	
	@Override
	public Double visitNum(ElParser.NumContext ctx) {
		return Double.parseDouble(ctx.NUM().getText());
	}
	
	@Override
	public Double visitMultiply(ElParser.MultiplyContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left * right;
	}
	
	@Override
	public Double visitSubtract(ElParser.SubtractContext ctx) {
		Double left  = visit(ctx.stat(0));
		Double right = visit(ctx.stat(1));
		return left - right;
	}
	
	@Override
	public Double visitId(ElParser.IdContext ctx) {
		return context.get(ctx.ID().getText());
	}
	
	@Override
	public Double visitParenthesis(ElParser.ParenthesisContext ctx) {
		return visit(ctx.stat());
	}
	
	@Override
	public Double visitAssign(ElParser.AssignContext ctx) {
		Double val = visit(ctx.stat());
		context.put(ctx.ID().getText(), val);
		return val;
	}
}
