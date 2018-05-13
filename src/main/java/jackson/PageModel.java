package jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * @auther 儒尊
 * @date 2018/5/13
 **/
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
/*
@JsonSubTypes({@JsonSubTypes.Type(value = InputPageModel.class, name = "input")
					  , @JsonSubTypes.Type(value = NumberPageModel.class, name = "number")})
*/
public abstract class PageModel {
	
	private String type;
	private String name;
	private String uiType;
	private String label;
}
