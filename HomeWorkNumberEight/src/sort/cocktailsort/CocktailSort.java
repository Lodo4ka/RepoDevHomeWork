package sort.cocktailsort;

/**
 * Created by lodo4ka on 08/05/2017.
 */
public class CocktailSort {

    public static Integer[] cocktailSort(Integer [] array){
        boolean swapped = true;
        int i = 0;
        int j = array.length-1;
        while (i < j && swapped){
            swapped =false;
            for (int k = i; k < j; k++) {
                if(array[k] > array[k+1]){
                    int temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                    swapped = true;
                }
            }
            j--;
            if(swapped){
                swapped =false;
                for (int k = j; k > i; k--) {
                    if(array[k] < array[k-1]){
                        int temp = array[k];
                        array[k] = array[k-1];
                        array[k-1] = temp;
                        swapped = true;
                    }
                }
            }
            i++;
        }
        return array;
    }
}
