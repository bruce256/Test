package jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @auther 儒尊
 * @date 2018/5/13
 **/
public class JsonTypeInfoTest {
	
	public static void main(String[] args) {
		String inputJson = " {\n" +
				"        \"type\": \"input\",\n" +
				"        \"label\": \"商品条码\",\n" +
				"        \"uiType\": \"input\",\n" +
				"        \"input\" : \"lvsheng\"\n" +
				"        \n" +
				"      }";
		ObjectMapper mapper = new ObjectMapper();
		try {
			InputPageModel inputPageModel = mapper.readValue(inputJson, InputPageModel.class);
			System.out.println(inputPageModel.getInput());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String numberJson = " {\n" +
				"        \"type\": \"number\",\n" +
				"        \"label\": \"商品条码\",\n" +
				"        \"uiType\": \"input\",\n" +
				"        \"number\" : 110\n" +
				"        \n" +
				"      }";
		try {
			NumberPageModel inputPageModel = mapper.readValue(numberJson, NumberPageModel.class);
			System.out.println(inputPageModel.getNumber());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
