package search.linearSearch;

public class LinearSearch {
    public static int linearSearch(int[] arr, int key) {
        // Проходим по всем элементам массива.
        for (int i = 0; i < arr.length; i++) {
            // Если текущий элемент равен ключу поиска, возвращаем его индекс.
            if (arr[i] == key) {
                return i;
            }
        }
        // Если ключ поиска не найден, возвращаем -1.
        return -1;
    }

    public static void main(String[] args) {
        // Определяем массив.
        int[] arr = {3, 2, 1, 4, 5};
        // Определяем ключ поиска.
        int key = 4;
        // Выполняем линейный поиск элемента с ключом в массиве.
        int index = linearSearch(arr, key);
        // Если элемент найден, выводим сообщение об этом.
        if (index != -1) {
            System.out.println("Элемент " + key + " найден на позиции " + index);
            // Если элемент не найден, выводим сообщение об этом.
        } else {
            System.out.println("Элемент " + key + " не найден в массиве.");
        }
    }
}
