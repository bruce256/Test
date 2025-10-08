package xmlbeans;


import java.util.Scanner;
import java.util.regex.Pattern;
public class Main {
    public static Pattern digit = Pattern.compile("[\\d]+");

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(Main.bigNumberAdd("101", "23"));
        System.out.println(Main.bigNumberAdd("999", "111"));
        System.out.println("Hello World!");
    }

    public static String bigNumberAdd(String num1, String num2) {
        if(num1 == null || num2 == null) {
            throw new IllegalArgumentException("input is null!");
        }
        if (!digit.matcher(num1).matches() || !digit.matcher(num2).matches()) {
            throw new IllegalArgumentException("input is illegal! num1: " + num1 + ", num2: " + num2);
        }

        StringBuffer result = new StringBuffer();
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int jin = 0;
        for(;idx1 >=0 || idx2 >= 0; idx1--, idx2--) {
            int a = 0;
            if (idx1 >= 0) {
                a = num1.charAt(idx1) - '0';
            }
            int b = 0;
            if (idx2 >= 0) {
                b = num2.charAt(idx2) - '0';
            }
            int cur = (a + b + jin) % 10;
            jin = (a + b + jin) / 10;
            result.insert(0, cur);
        }
        if (jin > 0) {
            result.insert(0, jin);
        }
        return result.toString();
    }
}