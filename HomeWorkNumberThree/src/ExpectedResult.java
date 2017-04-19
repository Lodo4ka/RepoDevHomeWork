/**
 * Created by lodo4ka on 19/04/2017.
 */
public class ExpectedResult {

    public static void main(String[] args) {
        int a = 30;
        int b = a;
        a++;
        Integer c = 6;
        Integer d = c++;
        d--;
        String s = "string";
        s.replace('s', '#');
        System.out.println("a = " + a); // a = ...
        System.out.println("b = " + b); // b = ...
        System.out.println("c = " + c); // c = ...
        System.out.println("d = " + d); // d = ...
        System.out.println("s = " + s); // s = ..
    }
}
