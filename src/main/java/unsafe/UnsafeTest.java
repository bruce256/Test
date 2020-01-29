package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LvSheng
 * @date 2019/12/14
 **/
public class UnsafeTest {
	
	public static long valueOffset;
	public static long valueOffset1;
	public static long valueOffset2;
	
	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			Unsafe us = (Unsafe) f.get(null);
			valueOffset = us.objectFieldOffset
					(UnsafeTest.class.getDeclaredField("value"));
			valueOffset1 = us.objectFieldOffset
					(UnsafeTest.class.getDeclaredField("value1"));
			valueOffset2 = us.objectFieldOffset
					(UnsafeTest.class.getDeclaredField("value2"));
			System.out.println(valueOffset);
			System.out.println(valueOffset1);
			System.out.println(valueOffset2);
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}
	
	private volatile long value;
	private volatile long value1;
	private volatile long value2;
	
	public static void main(String[] args) {
		try {
			System.out.println("start");
			UnsafeTest ut = new UnsafeTest();
			Field      f  = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			Unsafe us = (Unsafe) f.get(null);
			us.getAndSetInt(ut, UnsafeTest.valueOffset, 1000);
			System.out.println(ut.value);
			us.getAndSetInt(ut, UnsafeTest.valueOffset, 7000);
			System.out.println(ut.value);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
