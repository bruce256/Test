package ognl;


import ognl.domain.SlDept;
import ognl.domain.SlEmployee;

import java.util.HashMap;

/**
 * @author   : ruzun
 * @date     : 2017/2/12 上午3:55
 */
public class OgnlTest {

	public static void main(String[] args) throws OgnlException {
		// 新建一个部门对象并设置部门名称
		SlDept dept = new SlDept();
		dept.setName("销售部");

		// 新建一个员工对象并设置员工姓名
		SlEmployee emp = new SlEmployee();
		emp.setName("张三");
		emp.setSlDept(dept);
		emp.setAge("22");

		// 构建一个OgnlContext对象
		OgnlContext context = new OgnlContext(new HashMap());

		// 将上述部门和员工对象放入Ognl上下文环境中
		context.put("dept", dept);
		context.put("emp", emp);

		// 将员工设置为根对象
		context.setRoot(emp);

		// 构建Ognl表达式的树状表示,用来获取
		Object expression = Ognl.parseExpression("#dept.name");

		// 解析树状表达式，返回结果
		Object deptName = Ognl.getValue(expression, context, context.getRoot());

		System.out.println(deptName);

		expression = Ognl.parseExpression("#emp.slDept.name");
		deptName = Ognl.getValue(expression, context, context.getRoot());
		System.out.println(deptName);

		expression = Ognl.parseExpression("slDept.name");
		deptName = Ognl.getValue(expression, context, context.getRoot());
		System.out.println(deptName);


		// 从根对象中直接获取部门名称长度，非静态方法
		expression = Ognl.parseExpression("slDept.name.length()");
		Object length = Ognl.getValue(expression, context, context.getRoot());
		System.out.println(length);

		// 在Ognl表达式中使用静态方法
		expression = Ognl.parseExpression("@java.lang.Integer@valueOf(age)");
		length = Ognl.getValue(expression, context, context.getRoot());
		System.out.println(length);

		expression = Ognl.parseExpression("age = 30");
		Object value = Ognl.getValue(expression, context, context.getRoot());
		System.out.println(value);
		System.out.println(emp.getAge());

		Integer num = 0;
		context.put("num", num);
		expression = Ognl.parseExpression("#num = 5");
		Object value1 = Ognl.getValue(expression, context, context.getRoot());
		System.out.println(value1);
		System.out.println(num);
	}


}