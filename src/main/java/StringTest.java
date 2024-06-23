/**
 * @author LvSheng
 * @date 2021/11/11
 **/
public class StringTest {
    public static void main(String[] args) {

        String e = new String("3").intern();
        String f = new String("3").intern();
        System.out.println(
            "\nString e = new String(\"3\").intern();\n" + "String f = new String(\"3\").intern();\n" + "e == f ? " +
                (e == f));
        String str = "a";
        /*for (int i = 0; i < 1000; i++) {
            str += "b";
        }*/
        System.out.println(str);
    }
}
