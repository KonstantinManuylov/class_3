package class3.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task3 {
    public static void main(String[] args) {
//        try {
//            System.out.println(divideByZero(4, 0));
//        } catch (DivideByZeroException e) {
//            System.out.println(e.getMessage());
//        }
        try {
            fileNotFound("asdfgh");
        } catch (NonExistedFileException e) {
            e.printStackTrace();
        }

    }

    public static int divideByZero(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException("Деление на ноль.");
        }
        return a / b;
    }

    public static void fileNotFound(String path) throws NonExistedFileException {
        try {
            FileReader fr = new FileReader(path);
        } catch (FileNotFoundException e) {
//            throw new NonExistedFileException("Файл не найден.");
        }
    }
}
