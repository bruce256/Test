package retry;

import org.springframework.retry.annotation.Retryable;

/**
 * @author 儒尊
 * @date 2017/05/06
 */
public class SayHello {

	@Retryable(maxAttempts = 4)
	public void callee() {
		System.out.println("hello everyone");
		throw new NullPointerException();
	}
	
	public void caller() {
		this.callee();
	}
}
