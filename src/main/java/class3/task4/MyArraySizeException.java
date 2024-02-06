package class3.task4;

public class MyArraySizeException extends IllegalArgumentException {
    public MyArraySizeException() {
        super("Некорректный размер массива. ");
    }
}
