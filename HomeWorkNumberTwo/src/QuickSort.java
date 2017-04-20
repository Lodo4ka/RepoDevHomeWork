/**
 * Created by lodo4ka on 19/04/2017.
 */
public class QuickSort {

    public QuickSort() {
    }

    int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                ++i;
            }

            while (array[j] > pivot) {
                --j;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
            }
        }

        return i;
    }

    void quickSort(int[] array, int left, int right) {
        int index = this.partition(array, left, right);
        if (left < index - 1) {
            this.quickSort(array, left, index - 1);
            if (index < right) {
                this.quickSort(array, index, right);
            }
        }
    }
}


