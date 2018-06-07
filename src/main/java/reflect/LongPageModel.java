package reflect;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jackson.NumberPageModel;
import lombok.Data;

/**
 * @auther 儒尊
 * @date 2018/5/13
 **/
@Data
@JsonTypeName(value = "long")
public class LongPageModel extends NumberPageModel {
	
	private Integer num;
}
