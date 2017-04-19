import java.util.Arrays;

/**
 * Created by lodo4ka on 19/04/2017.
 */
public class QuickandBubbleSort {

    public static void main(String[] args) {
        int[] arrays1 = new int[20];
        int[] arrays2 = new int[20];
        fillInArray(arrays1);
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arrays1, 0, arrays1.length - 1);
        System.out.println(Arrays.toString(arrays1));
        fillInArray(arrays2);
        BubbleSort bubbleSort = new BubbleSort();
        BubbleSort.bubbleSortTwo(arrays2);
        System.out.println(Arrays.toString(arrays2));
    }

    public static int[] fillInArray(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            array[i] = (int)Math.round(Math.random() * 100.0D);
        }

        return array;
    }
}
