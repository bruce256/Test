package jvm;

import java.io.IOException;

/**
 * @author LvSheng
 * @date 2021/11/3
 **/
public class CharWrapper {
    private char c = 'a';

    public static void main(String[] args) throws IOException {
        CharWrapper charWrapper = new CharWrapper();
        System.out.println(charWrapper);
        System.in.read();
    }
}
