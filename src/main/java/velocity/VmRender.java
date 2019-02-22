package velocity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.List;

/**
 * @author lvsheng
 * @date 2019-02-22
 **/
public class VmRender {
	
	VelocityEngine ve = new VelocityEngine();
	
	public static void main(String[] args) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		// 载入（获取）模板对象
		Template        t   = ve.getTemplate("pdfTable.vm");
		VelocityContext ctx = new VelocityContext();
		// 域对象加入参数值
		
		ObjectMapper mapper = new ObjectMapper();
		JSONObject   item1  = new JSONObject();
		item1.put("MoneyField-JSFLNXEV", 13);
		item1.put("TextField-JSFLNXEW", "采购大饼");
		JSONObject item2 = new JSONObject();
		item2.put("MoneyField-JSFLNXEV", 15);
		item2.put("TextField-JSFLNXEW", "团建经费");
		
		List<JSONObject> items = Lists.newArrayList(item1, item2);
		ctx.put("TableField-JSFLNNTH", items);
		
		StringWriter sw = new StringWriter();
		t.merge(ctx, sw);
		
		System.out.println(sw.toString());
		
	}
}
