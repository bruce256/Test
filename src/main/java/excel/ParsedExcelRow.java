package excel;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * excel 单行
 *
 * @author 儒尊
 * @date 2017/06/21
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ParsedExcelRow implements Serializable {
	
	private Integer rowIndex;
	private List<String> cellList = Lists.newArrayList();
	
	public ParsedExcelRow(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}
	
	// 判断是否是空行
	public boolean isEmpty() {
		if (cellList == null || cellList.size() == 0) {
			return true;
		}
		
		for (String cell : cellList) {
			if (cell != null) {
				return false;
			}
		}
		return true;
	}
}
