package annotate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LvSheng
 * @date 2020/2/26
 **/
public class Count<T>{
	
	public static String prefix1 = "0X01";
	public static String prefix2 = "0X02";
	public static String prefix3 = "0X03";

	public void count(String input) {
		if (input == null || input.isEmpty()) return;
		
		Map<String, Integer> map        = new LinkedHashMap<>();
		String[]             array      = input.split("\\,");
		StringBuffer         sb         = new StringBuffer();
		boolean              hasContent = false;
		for (int i = 0; i < array.length; i++) {
			if (isLegalPrefix(array[i]) && !hasContent) {
				sb.append(array[i]);
			} else if (!isLegalPrefix(array[i])) {
				sb.append("+")
				  .append(array[i]);
				hasContent = true;
			} else if (isLegalPrefix(array[i]) && hasContent) {
				map.compute(sb.toString(), (key, value) -> {
					value = value == null ? 1 : ++value;
					return value;
				});
				// 开始下一轮
				sb = new StringBuffer();
				hasContent = false;
			}
		}
		if (sb.length() > 0) {
			map.compute(sb.toString(), (key, value) -> {
				value = value == null ? 1 : ++value;
				return value;
			});
		}
		
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey() + "=" + entry.getValue());
			System.out.print(",");
		}
	}
	
	private boolean isLegalPrefix(String line) {
		return prefix1.equals(line) || prefix2.equals(line) || prefix3.equals(line);
	}
	
	public static void main(String[] args) {
		String input = "0X01,1,0X02,0X03,0X04,1,0X01,1,0X03,1";
		Count  count = new Count();
		count.count(input);
		
	}
}