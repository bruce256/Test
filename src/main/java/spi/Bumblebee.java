package spi;

/**
 * @author LvSheng
 * @date 2019/11/27
 **/
public class Bumblebee implements Robot {
	
	@Override
	public void sayHello() {
		System.out.println("Hello, I am Bumblebee.");
	}
}
