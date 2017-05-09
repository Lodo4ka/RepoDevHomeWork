package sort;

import sort.cocktailsort.CocktailSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lodo4ka on 08/05/2017.
 */
public class EntryPoint2 {

    public static void main(String[] args) {

        Integer[] arrayInt = new Integer[100];
        EntryPoint.arrayInsert(arrayInt);
        CocktailSort.cocktailSort(arrayInt);
        System.out.println(Arrays.toString(arrayInt));
    }
}
