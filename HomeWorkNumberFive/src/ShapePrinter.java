/**
 * Created by lodo4ka on 25/04/2017.
 */
public class ShapePrinter {

    public void print(Shape anything){

        if (anything instanceof Square){
            System.out.println("This's square");
        }
        else if(anything instanceof Circle){
            System.out.println("This's circle");
        }
        else if (anything instanceof Triangle){
            System.out.println("This's triagle");
        }
        else {
            System.out.println("This's shape");
        }
    }
}
