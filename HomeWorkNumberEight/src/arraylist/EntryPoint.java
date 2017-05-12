package arraylist;

/**
 * Created by lodo4ka on 12/05/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.add(010);

        System.out.println(myArrayList.get(2));
    }
}
