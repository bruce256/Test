package antlr;

import antlr.gen.power.powerBaseVisitor;
import antlr.gen.power.powerParser;

/**
 * @author lvsheng
 * @date 2019-03-18
 **/
public class PowerVisitorImpl extends powerBaseVisitor<Double> {
	
	@Override
	public Double visitInt(powerParser.IntContext ctx) {
		return Double.parseDouble(ctx.INT().getText());
	}
	
	@Override
	public Double visitPow(powerParser.PowContext ctx) {
		Double left  = visit(ctx.express(0));
		Double right = visit(ctx.express(1));
		
		return Math.pow(left.doubleValue(), right.doubleValue());
	}
	
	@Override
	public Double visitParenthesis(powerParser.ParenthesisContext ctx) {
		return visit(ctx.express());
	}
	
	@Override
	public Double visitProg(powerParser.ProgContext ctx) {
		return visit(ctx.express());
	}
}
