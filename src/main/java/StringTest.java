/**
 * @author LvSheng
 * @date 2021/11/11
 **/
public class StringTest {
    public static void main(String[] args) {
        String str = "a";
        for (int i = 0; i < 1000; i++) {
            str += "b";
        }
        System.out.println(str);
    }
}
