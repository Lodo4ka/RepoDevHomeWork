/**
 * Created by lodo4ka on 19/04/2017.
 */
public class BubbleSort {

    public BubbleSort() {
    }

    public static int[] bubbleSort(int[] numArray) {
        if(numArray != null && numArray.length > 1) {
            for(int i = 0; i < numArray.length; ++i) {
                for(int j = 1; j < numArray.length; ++j) {
                    if(numArray[j - 1] > numArray[j]) {
                        numArray[j] += numArray[j - 1];
                        numArray[j - 1] = numArray[j] - numArray[j - 1];
                        numArray[j] -= numArray[j - 1];
                    }
                }
            }

            return numArray;
        } else {
            return numArray;
        }
    }

    public static int[] bubbleSortTwo(int[] list) {
        for(int i = 0; i < list.length - 1; ++i) {
            for(int j = 0; j < list.length - 1 - i; ++j) {
                if(list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

        return list;
    }

    public static void bubbleSortThree(int[] num) {
        boolean flag = true;

        while(flag) {
            flag = false;

            for(int j = 0; j < num.length - 1; ++j) {
                if(num[j] < num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;
                }
            }
        }

    }
}

