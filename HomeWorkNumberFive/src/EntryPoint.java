import model.*;

/**
 * Created by lodo4ka on 26/04/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {
        ShapePrinter shapePrinter = new ShapePrinter();
        Shape circle = new Circle();
        Shape square = new Square();
        Shape triangle = new Triangle();
        Shape shape = new Shape();

        shapePrinter.print(shape);
        shapePrinter.print(circle);
        shapePrinter.print(square);
        shapePrinter.print(triangle);
    }
}
