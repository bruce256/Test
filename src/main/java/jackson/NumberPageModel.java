package jackson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

/**
 * @auther 儒尊
 * @date 2018/5/13
 **/
@Data
@JsonTypeName(value = "number")
public class NumberPageModel extends PageModel {
	
	private Integer number;
}
