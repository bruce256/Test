package antlr;

import antlr.gen.math.MathBaseVisitor;
import antlr.gen.math.MathParser;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 后根遍历序
 *
 * @author lvsheng
 * @date 2018/10/5
 **/
public class MathVisitorImpl extends MathBaseVisitor<Integer> {
	
	/**
	 * 存储变量值
	 */
	private Map<String, Integer> memory = Maps.newHashMap();
	
	@Override
	public Integer visitAssign(MathParser.AssignContext ctx) {
		String  id    = ctx.ID().getText();
		Integer value = visit(ctx.expr());
		this.memory.put(id, value);
		return value;
		
	}
	
	@Override
	public Integer visitPrintExpr(MathParser.PrintExprContext ctx) {
		Integer value = visit(ctx.expr());
		System.out.println(value);
		return value;
	}
	
	@Override
	public Integer visitInt(MathParser.IntContext ctx) {
		return Integer.valueOf(ctx.INT().getText());
	}
	
	@Override
	public Integer visitId(MathParser.IdContext ctx) {
		String id = ctx.ID().getText();
		if (memory.containsKey(id)) {
			return memory.get(id);
		}
		
		return 0;
	}
	
	@Override
	public Integer visitMulDiv(MathParser.MulDivContext ctx) {
		Integer left  = visit(ctx.expr(0));
		Integer right = visit(ctx.expr(1));
		
		if (ctx.op.getType() == MathParser.MUL) {
			return left * right;
		} else {
			return left / right;
		}
		
	}
	
	@Override
	public Integer visitAddSub(MathParser.AddSubContext ctx) {
		Integer left  = visit(ctx.expr(0));
		Integer right = visit(ctx.expr(1));
		
		if (ctx.op.getType() == MathParser.ADD) {
			return left + right;
		} else {
			return left - right;
		}
	}
	
	@Override
	public Integer visitParens(MathParser.ParensContext ctx) {
		return visit(ctx.expr());
	}
}
