import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lodo4ka on 19/04/2017.
 */
public class Fibonacci {


    public Fibonacci() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number x: ");
        int x = scanner.nextInt();
        System.out.println("Enter number y: ");
        int y = scanner.nextInt();
        List<Integer> listOfFib = new ArrayList();

        for(int i = y; i >= x; --i) {
            listOfFib.add(Integer.valueOf(fibonacci(i)));
            System.out.printf("Fibonacci of %d is: %d\n", new Object[]{Integer.valueOf(i), Integer.valueOf(fibonacci(i))});
        }

        System.out.println("Count of fibonacci " + listOfFib.size());
    }

    public static int fibonacci(int number) {
        return number != 0 && number != 1?fibonacci(number - 1) + fibonacci(number - 2):number;
    }
}
