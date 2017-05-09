package sort;

import sort.insertionsort.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;

public class EntryPoint {
    public static void main(String[] args) {


        Integer [] arrayInt = new Integer[100];
        arrayInsert(arrayInt);
        InsertionSort.insertIntoSort(arrayInt);
        System.out.println(Arrays.toString(arrayInt));
    }

    public static Integer [] arrayInsert(Integer [] array){

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs((int)(Math.random()*100));
        }
        return array;
    }
}
