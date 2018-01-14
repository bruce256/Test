package com.taobao.ls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

/**
 * @auther 儒尊
 * @date 2018/1/12
 **/
public class JacksonTest {
	
	/**
	 *
	 */
	public String json = "{\n" +
			"  \"success\": true,\n" +
			"  \"ignore\": true,\n" +
			"  \"modelData\": [\n" +
			"    {\n" +
			"      \"name\": \"icmp_global\",\n" +
			"      \"edit\": true,\n" +
			"      \"value\": {\n" +
			"        \"catId\": 5430,\n" +
			"        \"operatorId\": null\n" +
			"      },\n" +
			"      \"catId\": 5430,\n" +
			"      \"operatorId\": null,\n" +
			"      \"sellerId\": 1,\n" +
			"      \"id\": 1003285007,\n" +
			"      \"picture\": {\n" +
			"        \"picUploadApi\": \"/publish/uploadImage\",\n" +
			"        \"localFile\": true\n" +
			"      }\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"catId\",\n" +
			"      \"uiType\": \"hidden\",\n" +
			"      \"value\": 5430\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"operatorId\",\n" +
			"      \"uiType\": \"hidden\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"merchantId\",\n" +
			"      \"uiType\": \"text\",\n" +
			"      \"label\": \"Merchant ID\",\n" +
			"      \"value\": 1\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"merchantName\",\n" +
			"      \"uiType\": \"text\",\n" +
			"      \"label\": \"Merchant Name\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"productId\",\n" +
			"      \"uiType\": \"text\",\n" +
			"      \"label\": \"Product ID\",\n" +
			"      \"value\": 1003285007\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"title\",\n" +
			"      \"uiType\": \"input\",\n" +
			"      \"label\": \"Product Name\",\n" +
			"      \"required\": true,\n" +
			"      \"maxLength\": 150,\n" +
			"      \"showCounter\": true,\n" +
			"      \"supportAsyncCheck\": true,\n" +
			"      \"value\": \"测试商品23\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"customTag\",\n" +
			"      \"uiType\": \"input\",\n" +
			"      \"label\": \"Custom Tag\",\n" +
			"      \"maxLength\": 50,\n" +
			"      \"showCounter\": true\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"generalDescription\",\n" +
			"      \"uiType\": \"generalDescription\",\n" +
			"      \"label\": \"General Description\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"fulfillmentMode\",\n" +
			"      \"uiType\": \"select\",\n" +
			"      \"label\": \"Fulfillment Mode\",\n" +
			"      \"required\": true,\n" +
			"      \"dataSource\": [\n" +
			"        {\n" +
			"          \"value\": 1,\n" +
			"          \"text\": \"Seed\"\n" +
			"        },\n" +
			"        {\n" +
			"          \"value\": 2,\n" +
			"          \"text\": \"Dropship\"\n" +
			"        }\n" +
			"      ],\n" +
			"      \"value\": {\n" +
			"        \"value\": 2,\n" +
			"        \"text\": 2\n" +
			"      },\n" +
			"      \"placeholder\": \"please choose\"\n" +
			"    },\n" +
			"    {\n" +
			"      \"name\": \"returnPolicy\",\n" +
			"      \"uiType\": \"text\",\n" +
			"      \"label\": \"\"\n" +
			"    }\n" +
			"  ]\n" +
			"}";
	
	@Test
	public void jackson() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			JsonNode jsonNode  = objectMapper.readTree(json);
			JsonNode modelData = jsonNode.get("modelData");
			JsonNode jsonNode1 = modelData.get(0);
			System.out.println(jsonNode1.get("name").asText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
