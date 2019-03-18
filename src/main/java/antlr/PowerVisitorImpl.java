package antlr;

import antlr.gen.power.powerBaseVisitor;
import antlr.gen.power.powerParser;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * @author lvsheng
 * @date 2019-03-18
 **/
public class PowerVisitorImpl extends powerBaseVisitor<Long> {
	
	@Override
	public Long visitPow(powerParser.PowContext ctx) {
		Long left  = visit(ctx.INT(0));
		Long right = visit(ctx.INT(1));
		
		return (long) Math.pow(left.doubleValue(), right.doubleValue());
	}
	
	@Override
	public Long visitTerminal(TerminalNode node) {
		return Long.valueOf(node.getText());
	}
}
