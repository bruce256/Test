package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther 儒尊
 * @date 2017/9/2
 **/
public class LambdaTest {
	
	@Test
	public void lambda() {
		List<String> collect = Stream.of("a", "b").collect(Collectors.toList());
		for (String s : collect) {
			System.out.println(s);
		}
		
		BinaryOperator<Integer> binaryOperator = (acc, ele) -> acc + ele;
		Integer                 reduce         = Stream.of(1, 2, 3).reduce(1, binaryOperator);
		System.out.println(reduce);
		
		Optional<Integer> min = Stream.of(1, 2, 3).min(Comparator.naturalOrder());
		System.out.println(min.get());
		
		Integer sum = Stream.of(1, 2, 3).reduce(binaryOperator).get();
		System.out.println(sum);
	}
}
