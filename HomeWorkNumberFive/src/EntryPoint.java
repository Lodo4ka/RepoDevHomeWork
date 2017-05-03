/**
 * Created by lodo4ka on 26/04/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {

        ShapePrinter shapePrinter = new ShapePrinter();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        Shape shape = new Shape();

        shapePrinter.print(shape);
        shapePrinter.print(circle);
        shapePrinter.print(square);
        shapePrinter.print(triangle);

    }

}
