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
                   Integer temp = list.get(k);
                   list.set(k, list.get(k+1));
                   list.set(k+1, temp);
                   swapped =true;
               }
           }
           j--;
           if (swapped){
               swapped = false;
               for (int k = j; k > i; k--) {
                   if(list.get(k) < list.get(k-1)){

                       Integer temp=list.get(k);
                       list.set(k, list.get(k-1));
                       list.set(k-1, temp);
                       swapped =true;
                   }
               }
           }
           i++;
       }
       return list;
    }
}
