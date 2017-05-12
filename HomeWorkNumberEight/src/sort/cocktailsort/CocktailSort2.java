package sort.cocktailsort;

import java.util.List;

/**
 * Created by lodo4ka on 12/05/2017.
 */
public class CocktailSort2 {


    public static void cocktailSort(List<Integer> list) {
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < list.size() - 2; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    //test whether the two elements are in the wrong order
                    int u1 = list.get(i);
                    int u2 = list.get(i + 1);
                    int temp = u1;
                    u1 = u2;
                    u2 = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //we can exit the outer loop here if no swaps occured
                break;
            }
            swapped = false;
            for (int i = list.size() - 2; i >= 0; i--) {
                if (list.get(i) > list.get(i + 1)) {
                    int u1 = list.get(i);
                    int u2 = list.get(i + 1);
                    int temp = u1;
                    u1 = u2;
                    u2 = temp;
                    swapped = true;
                }
            }
        }
        while (swapped);
    }
}

