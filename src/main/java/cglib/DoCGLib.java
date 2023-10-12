package cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author 儒尊
 * @date 2017/05/07
 */
public class DoCGLib {

	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lvsheng1/Downloads");
		CglibProxy proxy = new CglibProxy();
		//通过生成子类的方式创建代理类
		SayHello proxyImp = (SayHello) proxy.getProxy(SayHello.class);
		proxyImp.callee();
	}
}
