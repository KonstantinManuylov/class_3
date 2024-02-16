package hometask;

public class Human {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private Long phoneNum;
    private String gender;

    public Human(String surname, String name, String patronymic, String birthDate, Long phoneNum, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s> <%s> <%s> <%s> <%s> <%s> \n", surname, name, patronymic, birthDate, phoneNum, gender);
    }
}
