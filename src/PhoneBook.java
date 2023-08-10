import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneBook {
    ArrayList<Person> persons;
    public PhoneBook(ArrayList<Person> persons){
        this.persons = persons;
    }

    public void addPerson(Person person){
        this.persons.add(person);
    }

    public void writePerson(){
        for (Person person : persons) {
            String path = String.format("%s.txt", person.secondName);
            try (FileWriter writer = new FileWriter(path, true)) {
                String text = person.toString();
                writer.write(text);
            } catch (IOException ex) {
                System.out.println("Возникла ошибка записи в файл:" + ex);
            }
        }

    }
}

