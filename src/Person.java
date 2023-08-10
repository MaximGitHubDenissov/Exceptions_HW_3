import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Person {
    String name;
    String secondName;
    String surname;
    String birthdate;
    String phone;
    String gender;

    public Person() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите фамилию пользователя");
            String secondName = in.nextLine();
            this.secondName = isNotEmpty(secondName);
        } while (this.secondName == null);

        do {
            System.out.println("Введите имя пользователя");
            String name = in.nextLine();
            this.name = isNotEmpty(name);
        } while (this.name == null);
        do {
            System.out.println("Введите отчество пользователя");
            String surname = in.nextLine();
            this.surname = isNotEmpty(surname);
        } while (this.surname == null);

        do {
            System.out.println("Введите дату рождения в формате(dd.mm.yyyy)");
            String birthdate = in.nextLine();
            this.birthdate = isValidDate(birthdate);
        } while (this.birthdate == null);
        do {
            System.out.println("Введите номер телефона (11-ти значное число) без пробелов и других символов");
            String phone = in.nextLine();
            this.phone = isValidPhone(phone);
        } while (this.phone == null);
        do {
            System.out.println("Введите пол (m/f):");
            String gender = in.nextLine();
            this.gender = isValidGender(gender);
        } while (this.gender == null);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s \n", secondName, name, surname,birthdate, phone, gender);
    }

    public String isNotEmpty(String string) {
        string = string.trim();
        if (string.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
            return null;
        } else {
            return string;
        }
    }
    public String isValidDate(String string){
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(string);
            return string;
        } catch (ParseException e) {
            System.out.println("Не верный формат даты");
            return null;
        }
    }
    public String isValidPhone(String string){
        if (string.length() != 11) {
            System.out.println("Нужно ввести 11 цифр");
            return null;
        } else {
            try {
                Long.parseLong(string);
                return string;
            } catch (NumberFormatException e) {
                System.out.println("Нужно вводить цифры");
                return null;

            }
        }
    }
    public String isValidGender(String string){
        if (string.equals("f") || string.equals("m")) {
            return string;
        } else {
            System.out.println("Нужно вводить m или f");
            return null;
        }
    }
}
