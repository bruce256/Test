package jackson.model;

import lombok.Data;

/**
 * @author lvsheng
 * @date 2018/9/5
 **/
@Data
public class Response<T> {
	
	private int    status;
	private String message;
	private T      data;
	
	
}
