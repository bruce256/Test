package excel;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @auther 儒尊
 * @date 2018/2/27
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ParsedWorkBook {
	
	private List<ParsedWorkSheet> sheetList = Lists.newArrayList();
}
