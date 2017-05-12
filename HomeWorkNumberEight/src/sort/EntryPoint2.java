package sort;

import sort.cocktailsort.CocktailSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lodo4ka on 08/05/2017.
 */
public class EntryPoint2 {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        arrayInsert(integerList);
        CocktailSort.cocktailSort(integerList);
        for (Integer i: integerList
             ) {
            System.out.print(i + " ");

        }
    }

    public static List<Integer> arrayInsert(List<Integer> array){

        for (int i = 0; i < 10; i++) {
            array.add(Math.abs((int)(Math.random()*100)));
        }
        return array;
    }
}
