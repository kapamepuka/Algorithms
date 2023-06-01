package hm_2;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

public class homework_2 {
    // Кол-во элементов
    private static final int COUNT_ELEMENTS = 15;
    // Максимальное значение
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        int[] array = new int[COUNT_ELEMENTS];
        Random random = new Random();

        // Завполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_VALUE);
        }

        // Вывод исходного массива
        Logger logger = Logger.getAnonymousLogger();
        logger.info(Arrays.toString(array));

        // Сортировка и вывод отсортированоого массива
        logger.info(Arrays.toString(heapSort(array)));
    }

    public static int[] heapSort(int[] array) {
        int size = array.length;

        // Построенеи кучи
        for (int i = size / 2 - 1; i > 0; i--) {
            heapify(array, size, i);
        }

        // Извлечение элементов из кучи
        for (int i = size - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
        return array;
    }

    public static void heapify(int[] array, int heapSize, int node) {
        int largest = node; // Инициализируем наибольший элемент как корень
        int l = 2*node + 1; // левый = 2*node + 1
        int r = 2*node + 2; // правый = 2*node + 2

        // Если левый дочерний элемент больше корня
        if (l < heapSize && array[l] > array[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < heapSize && array[r] > array[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != node)
        {
            int swap = array[node];
            array[node] = array[largest];
            array[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}