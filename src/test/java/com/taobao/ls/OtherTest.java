package com.taobao.ls;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LvSheng
 * @date 2020/1/31
 **/
public class OtherTest {
	
	static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
	
	static final int spread(int h) {
		return (h ^ (h >>> 16)) & HASH_BITS;
	}
	
	@Test
	public void xor() {
		int a      = 0x70701111;
		int spread = spread(a);
		System.out.println(Integer.toHexString(spread));
	}
	
	@Test
	public void concurrentHm() {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(17);
		map.put(10, 10);
	}
}
