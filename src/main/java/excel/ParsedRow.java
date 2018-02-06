package excel;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * @auther 儒尊
 * @date 2018/2/5
 **/
@Data
public class ParsedRow {
	
	private Integer rowIndex;
	private Map<Integer, String> cellMap = Maps.newLinkedHashMap();
}
