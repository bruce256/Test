package jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.List;

/**
 * @author LvSheng
 * @date 2023/10/13
 **/
public class SqlParserTest {
    public static void main(String[] args) {
        try {
            Statement   stmt        = CCJSqlParserUtil.parse("select a, b, c from t where a = '1' and b = 3");
            Select      select      = (Select) stmt;
            PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
            System.out.println(select.getSelectBody());

            List<SelectItem>     selectItems          = plainSelect.getSelectItems();
            SelectExpressionItem selectExpressionItem = new SelectExpressionItem();
            selectExpressionItem.setExpression(new Column("merchant_id"));
            selectItems.add(selectExpressionItem);
            System.out.println(select.getSelectBody());

            Expression where    = plainSelect.getWhere();
            EqualsTo   equalsTo = new EqualsTo();
            equalsTo.setLeftExpression(new Column("merchant_id"));
            equalsTo.setRightExpression(new StringValue("4000"));
            where = new AndExpression(where, equalsTo);
            plainSelect.setWhere(where);
            System.out.println(select.getSelectBody());
        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }
    }
}
