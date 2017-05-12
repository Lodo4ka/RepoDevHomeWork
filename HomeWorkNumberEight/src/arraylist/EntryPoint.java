package arraylist;

import java.util.ArrayList;

/**
 * Created by lodo4ka on 12/05/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.add(010);

        ArrayList<Integer> list = new ArrayList<>();

        list.add(19);
        list.add(20);
        list.add(80);

        System.out.println(list);

        System.out.println(myArrayList.get(2));
    }
}
