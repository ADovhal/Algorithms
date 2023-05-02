package sortings;


import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {


        int[] array = {1,8,5,6,2,3,4,9,7};

        System.out.println(Arrays.toString(selectionSort(array)));
    }
//
//    public static int[] SelectionSort(int[] array){
//
////        int[] sortedArray = new int[array.length];
//
//        for(int left = 0; left < array.length; left++){
//            int minInd = left;
//            for(int i = left; i < array.length; i++){
//                if(array[i]<array[minInd]) minInd = i;
//            }
//            swap(array, left, minInd);
//            System.out.println(Arrays.toString(array));
//        }
//
//        return array;
//    }
//
//    private static void swap(int[] array, int current, int minInd) {
//        int temp = array[minInd];
//        array[minInd] = array[current];
//        array[current] = temp;
//
//    }
//}
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // меняем местами arr[min_idx] и arr[i]
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
