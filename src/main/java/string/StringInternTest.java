package string;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @auther: LvSheng
 * @date: 2024/6/23
 * @description:
 */
@Slf4j
public class StringInternTest {
    public static void main(String[] args) {
        log.info("start");
        long begin = System.currentTimeMillis();
        int  size  = 100000000;
        try {
            List<String> list =
                IntStream.rangeClosed(1, size).mapToObj(i -> String.valueOf(i).intern()).collect(Collectors.toList());
            log.info("size:{} took:{}", size, System.currentTimeMillis() - begin);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
