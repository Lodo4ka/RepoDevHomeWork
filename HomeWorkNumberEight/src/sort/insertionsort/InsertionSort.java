package sort.insertionsort;

import java.util.List;

public class InsertionSort {

    public static void insertIntoSort(List<Integer> list){

       int i, j;
        for (i = 0; i < list.size(); i++) {
            Integer tmp = list.get(i);
            j = i;
            while ((j > 0) && (list.get(j -1) > tmp)){
                list.set(j, list.get(j -1));
                j--;
            }
            list.set(j, tmp);
        }
    }
}
