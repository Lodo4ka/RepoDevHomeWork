import java.util.Scanner;

/**
 * Created by lodo4ka on 19/04/2017.
 */
public class AreaOfaTriangle {
    public AreaOfaTriangle() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        System.out.println("Please select your choice:");
        double firstSide;
        double secondSide;
        double area;
        if (choose == 1) {
            System.out.println("Your choose the area of the triangle with three sides:");
            System.out.println("Please enter triangle side A");
            firstSide = (double) scanner.nextInt();
            System.out.println("Please enter triangle side B");
            secondSide = (double) scanner.nextInt();
            System.out.println("Please enter triangle side C");
            double thirdSide = scanner.nextDouble();
            if (firstSide + secondSide > thirdSide && firstSide + thirdSide > secondSide && secondSide + thirdSide >
                    firstSide) {
                double semiperimeter = 0.5 * (firstSide + secondSide + thirdSide);
                area = Math.abs(Math.sqrt(semiperimeter * (semiperimeter - firstSide) * (semiperimeter - secondSide) * (semiperimeter - thirdSide)));
                System.out.println("The area of the triangle is " + area);
            } else {
                System.out.println("this triangle does not exist");
            }

        } else if (choose == 2) {
            System.out.println("Your choose the area of the triangle with angle and 2 sides");
            System.out.println("Please enter triangle first side");
            firstSide = (double) scanner.nextInt();
            System.out.println("Please enter triangle second side");
            secondSide = (double) scanner.nextInt();
            System.out.println("Please enter triangle angle between sides");
            double angle = scanner.nextDouble();
            area = 0.5 * firstSide * secondSide * Math.abs(Math.sin(angle));
            System.out.println("The area of the triangle is " + area);
        } else {
            System.out.println("Fail");
        }

    }
}
