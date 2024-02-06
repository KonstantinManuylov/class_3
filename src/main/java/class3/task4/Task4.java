package class3.task4;

import java.util.ArrayList;
import java.util.List;

/**
 Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 с детализацией, в какой именно ячейке лежат неверные данные.

 2. В методе main() вызвать полученный метод, обработать возможные исключения
 MyArraySizeException и MyArrayDataException и вывести результат расчета
 (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task4 {
    static String[][] arr = new String[][] {
            {"1", "1.5", "asdf"},
            {"1", "df", "1.5"},
            {"1", "h", "1.5"}
    };

    public static void main(String[] args) {
        System.out.println(sum2d(arr));

    }

    public static double sum2d(String[][] arr) {
        List<Point2d> indexes = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (!isNumber(arr[i][j])) {
                    indexes.add(new Point2d(i, j));
                } else sum += Double.parseDouble(arr[i][j]);
            }
        }
        if (!indexes.isEmpty()) {
            throw new MyArrayDataException(indexes);
        }
        return sum;
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}