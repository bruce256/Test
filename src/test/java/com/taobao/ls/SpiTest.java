package com.taobao.ls;

import org.junit.Test;
import spi.Robot;

import java.util.ServiceLoader;

/**
 * @author LvSheng
 * @date 2019/11/27
 **/
public class SpiTest {
	
	@Test
	public void sayHello() throws Exception {
		ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
		System.out.println("Java SPI");
		serviceLoader.forEach(Robot::sayHello);
	}
}
