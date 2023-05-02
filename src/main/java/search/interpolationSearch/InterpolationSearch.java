package search.interpolationSearch;

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int key) {
        // Определяем начальный и конечный индексы для поиска.
        int low = 0;
        int high = arr.length - 1;
        // Пока не достигнут конец массива и ключ находится в диапазоне между low и high.
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            // Используем формулу интерполяции для вычисления позиции элемента.
            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            // Если ключ находится в текущей позиции, возвращаем ее.
            if (arr[pos] == key) {
                return pos;
                // Если ключ меньше, чем значение в текущей позиции, ищем в левой половине массива.
            } else if (arr[pos] > key) {
                high = pos - 1;
                // Если ключ больше, чем значение в текущей позиции, ищем в правой половине массива.
            } else {
                low = pos + 1;
            }
        }
        // Если ключ не найден, возвращаем -1.
        return -1;
    }

    public static void main(String[] args) {
        // Определяем массив.
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Определяем ключ поиска.
        int key = 7;
        // Выполняем интерполяционный поиск элемента с ключом в массиве.
        int index = interpolationSearch(arr, key);
        // Если элемент найден, выводим сообщение об этом.
        if (index != -1) {
            System.out.println("Элемент " + key + " найден на позиции " + index);
            // Если элемент не найден, выводим сообщение об этом.
        } else {
            System.out.println("Элемент " + key + " не найден в массиве.");
        }
    }
}

