package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吕胜 lvheng1
 * @date 2024/2/19
 **/
public class FreemarkerDemo {
	
	public static void main(String[] args) throws Exception {
		// 创建Configuration对象，并设置模板路径
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
		configuration.setClassForTemplateLoading(FreemarkerDemo.class, "/templates");
		
		// 获取Template对象
		Template template = configuration.getTemplate("hello.ftl");
		String str = new String("{\n" +
										"    \"org_id\": \"20027005\",\n" +
										"    \"payapply_document_no\": \"AP-01C00776\",\n" +
										"    \"source_system_code\": \"CERP\",\n" +
										"    \"pay_type\": \"3\",\n" +
										"    \"pay_account\": \"000005531521\",\n" +
										"    \"pay_account_name\": \"UNICREDIT 55315/21 CAB 05364\",\n" +
										"    \"pay_tax_id\": \"\",\n" +
										"    \"payee_name\": \"\\\"NUOVA EDILIZIA CASTELLANO\\\" DI CASTELLANO ANSELMO\",\n" +
										"    \"payee_bank_acc_no\": \"000009999999\",\n" +
										"    \"payee_bank_name\": \"C/C FITTIZIO\",\n" +
										"    \"payee_bank_code\": \"99999\",\n" +
										"    \"payee_bank_swiftcode\": \"\",\n" +
										"    \"payee_country\": \"IT\",\n" +
										"    \"payee_address\": \"Via Torino, 4\",\n" +
										"    \"payee_tax_id\": \"03390420655\",\n" +
										"    \"sett_type\": \"1\",\n" +
										"    \"payment_method\": \"Check\",\n" +
										"    \"business_flag\": \"1\",\n" +
										"    \"pay_date\": \"2024-02-18\",\n" +
										"    \"payee_currency_code\": \"EUR\",\n" +
										"    \"foreign_amount\": \"110\",\n" +
										"    \"budget_code\": \"0803\",\n" +
										"    \"fastslow_flag\": \"1\",\n" +
										"    \"remark\": \"AP-01C00776\",\n" +
										"    \"create_by_name\": \"\",\n" +
										"    \"apply_date\": \"2024-02-18\"\n" +
										"}");
		// 创建数据模型
		Map<String, Object> dataModel = new HashMap<>();
		dataModel.put("name", "\"John");
		dataModel.put("age", 25);
		
		// 渲染模板
		StringWriter stringWriter = new StringWriter();
		template.process(dataModel, stringWriter);
		String output = stringWriter.toString();
		
		// 输出结果
		System.out.println(output);
	}
	
}
