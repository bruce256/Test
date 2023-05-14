package cglib;

/**
 * @author 儒尊
 * @date 2017/05/06
 */
public class SayHello {

	public void callee() {
		System.out.println("hello everyone");
	}
	
	public void caller() {
		this.callee();
	}
}
