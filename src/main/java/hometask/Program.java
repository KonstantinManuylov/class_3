package hometask;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом в заданном порядке:
 * <p>
 * Фамилия Имя Отчество дата рождения номер телефона пол
 * <p>
 * Форматы данных:
 * <p>
 * фамилия, имя, отчество - строки
 * дата рождения - строка формата dd.mm.yyyy
 * номер телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * <p>
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и
 * показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * <p>
 * Приложение должно распарсить полученную строку и выделить из них требуемые значения.
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
 * Можно использовать встроенные типы java и создать свои.
 * Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 * <p>
 * Если всё введено и обработано верно, должен создаться файл с названием,
 * равным фамилии, в него в одну строку должны записаться полученные данные, вида
 * <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
 * <p>
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Фамилию Имя Отчество, " +
                "дату рождения в формате дд.мм.гггг, " +
                "номер телефона, пол (m или f). " +
                "Все данные введите через пробел");

        String next = sc.nextLine();
        String[] split = next.split("\\s");

        String surname = split[0];
        String name = split[1];
        String patronymic = split[2];
        String birthday = split[3];
        String[] splitBirthday = birthday.split("\\.");
        String phoneNum = split[4];
        String gender = split[5];
        Long phoneNumber = null;
        String fileName = surname + ".txt";
        FileWriter fw = null;

        if (split.length != 6) {
            throw new IllegalArgumentException("Недостаточно данных.");
        }
        for (String unit : splitBirthday) {
            try {
                Integer.parseInt(unit);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Неверный формат даты");
            }
        }

        try {
            phoneNumber = Long.parseLong(phoneNum);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат номера телефона");
        }

        if (gender.equals("m") || gender.equals("f")) {
            System.out.println("Данные верны. Идёт запись в файл.");
        } else throw new MyGenderLetterException();

        Human human = new Human(surname, name, patronymic, birthday, phoneNumber, gender);
        try {
            fw = new FileWriter(fileName, true);
            fw.write(human.toString());
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            try {
                assert fw != null;
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
