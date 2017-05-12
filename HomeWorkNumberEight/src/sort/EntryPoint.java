package sort;

import sort.insertionsort.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntryPoint {
    public static void main(String[] args) {


        List<Integer> arrayInt = new ArrayList<Integer>();
        arrayInsert(arrayInt);
        InsertionSort.insertIntoSort(arrayInt);
        for (Integer i: arrayInt
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
