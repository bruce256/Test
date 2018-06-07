package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import reflect.LongPageModel;

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
		
		mapper.registerSubtypes(InputPageModel.class);
		mapper.registerSubtypes(NumberPageModel.class);
		mapper.registerSubtypes(LongPageModel.class);
		
		try {
			InputPageModel inputPageModel = ((InputPageModel) mapper.readValue(inputJson, PageModel.class));
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
			NumberPageModel numberPageModel = ((NumberPageModel) mapper.readValue(numberJson, PageModel.class));
			System.out.println(numberPageModel.getNumber());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String longJson = " {\n" +
				"        \"type\": \"long\",\n" +
				"        \"label\": \"商品条码\",\n" +
				"        \"uiType\": \"input\",\n" +
				"        \"num\" : 9910\n" +
				"        \n" +
				"      }";
		try {
			LongPageModel longPageModel = ((LongPageModel) mapper.readValue(longJson, NumberPageModel.class));
			System.out.println(longPageModel.getNum());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
