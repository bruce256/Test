package spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author LvSheng
 * @date 2019/11/27
 **/
@SPI
public interface Robot {
	
	void sayHello();
}
