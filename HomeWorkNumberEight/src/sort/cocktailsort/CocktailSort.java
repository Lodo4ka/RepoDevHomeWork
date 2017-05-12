package sort.cocktailsort;

import java.util.List;

public class CocktailSort {

    public static List<Integer> cocktailSort(List<Integer> list){
       boolean swapped = true;
       int i = 0;
       int j = list.size()-1;

       while (i < j && swapped){
           swapped =false;

           for (int k = i; k < j; k++) {
               if (list.get(k) > list.get(k + 1)){

                   int k1 = list.get(k);
                   int k2 = list.get(k + 1);
                   int temp = k1;
                   k1 = k2;
                   k2 = temp;
                   swapped =true;
               }
           }
           j--;
           if (swapped){
               swapped = false;
               for (int k = j; k > i; k--) {
                   if(list.get(k) < list.get(k-1)){
                       int k1 = list.get(k);
                       int k2 = list.get(k - 1);
                       int temp = k1;
                       k1 = k2;
                       k2 = temp;
                       swapped =true;
                   }
               }
           }
           i++;
       }
       return list;
    }
}
