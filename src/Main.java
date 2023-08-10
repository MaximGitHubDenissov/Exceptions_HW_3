import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    PhoneBook pb = new PhoneBook(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            pb.addPerson(new Person());
        }
    pb.writePerson();

    }
}