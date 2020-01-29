package com.taobao.ls;

import org.apache.dubbo.common.extension.ExtensionLoader;
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
	
	@Test
	public void dubboSpiTest() {
		ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
		Robot                  optimusPrime    = extensionLoader.getExtension("optimusPrime");
		optimusPrime.sayHello();
		Robot bumblebee = extensionLoader.getExtension("bumblebee");
		bumblebee.sayHello();
	}
}
