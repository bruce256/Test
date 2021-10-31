package com.taobao.ls;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lvsheng
 * @date 2018/12/16
 **/
public class PdfTest {

    @Test
    public void testFont() {
        System.out.println(Math.abs("dingbad73751f4cad512".hashCode()) % 100);
    }

    @Test
    public void wudongwu() {
        List<int[]> collect = IntStream.rangeClosed(1, 100)
                                       .boxed()
                                       .flatMap(a -> IntStream.rangeClosed(a, 100)
                                                              .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                                              .boxed()
                                                              .map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}))
                                       .collect(Collectors.toList());
    }

}
