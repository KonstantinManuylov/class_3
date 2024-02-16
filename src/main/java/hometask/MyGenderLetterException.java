package hometask;

import java.io.IOException;

public class MyGenderLetterException extends RuntimeException {
    public MyGenderLetterException() {
        super("Неверно задан пол.");
    }
}
