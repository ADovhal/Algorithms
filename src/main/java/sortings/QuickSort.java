package sortings;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // индекс опорного элемента
            quickSort(arr, left, pivotIndex - 1);  // сортировка левой части массива
            quickSort(arr, pivotIndex + 1, right); // сортировка правой части массива
        }
    }
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];  // выбор опорного элемента
        int i = left - 1;  // индекс элемента, который больше опорного

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // меняем элементы местами, чтобы i-ый элемент был меньше опорного
            }
        }
        swap(arr, i + 1, right); // перемещаем опорный элемент на своё место
        return i + 1; // возвращаем индекс опорного элемента
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
