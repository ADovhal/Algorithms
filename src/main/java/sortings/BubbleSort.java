package sortings;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(bubbleSortMaxToMin(array)));
        System.out.println(Arrays.toString(bubbleSortMinToMax(array)));
    }
    public static int[] bubbleSortMaxToMin(int[] array){
        int n = array.length;
        for(int i = 0; i < n - 1; i++){                                 //this Bubble Sort sorts array DESC;
            for(int j = 0; j < n - i - 1; j++){
                if(array[j] < array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSortMinToMax(int[] array){
        int n = array.length;
        for(int i = 0; i < n; i++){                                 //this Bubble Sort sorts array ASC;
            for(int j = 0; j < n - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


//    public static void main(String[] args) {
//        int[] array = {10, 2, 10, 3, 1, 2, 5};
//        System.out.println(Arrays.toString(array));
//        boolean needIteration = true;
//        while (needIteration) {
//            needIteration = false;
//            for (int i = 1; i < array.length; i++) {
//                if (array[i] < array[i - 1]) {
//                    swap(array, i, i-1);
//                    needIteration = true;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(array));
//    }
//
//    private static void swap(int[] array, int ind1, int ind2) {
//        int tmp = array[ind1];
//        array[ind1] = array[ind2];
//        array[ind2] = tmp;
//    }
}


