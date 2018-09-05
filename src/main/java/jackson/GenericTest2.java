package jackson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.model.Response;
import jackson.model.User;

import java.io.IOException;

/**
 * @author lvsheng
 * @date 2018/9/5
 **/
public class GenericTest2 {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static String       json   = "{\"status\":3,\"message\":\"test\",\"data\":{\"name\":\"ruzun\",\"age\":101}}";
	
	public static void main(String[] args) {
		try {
			Response<User> value = mapper.readValue(json, new TypeReference<Response<User>>() {
			});
			System.out.println(JSON.toJSONString(value));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeJson() throws JsonProcessingException {
		Response<User> response = new Response<>();
		response.setMessage("test");
		response.setStatus(3);
		User user = new User();
		user.setAge(101);
		user.setName("ruzun");
		response.setData(user);
		System.out.println(mapper.writeValueAsString(response));
	}
	
}