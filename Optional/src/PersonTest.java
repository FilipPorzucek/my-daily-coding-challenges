import java.util.Optional;
import java.util.function.Consumer;

public class PersonTest {
    public static void main(String[] args) {
        PersonDatabase db = new PersonDatabase();
        db.add(new Person(1,"Jan","Kowalski"));
        db.add(new Person(2,"Karol","Zawadzki"));
        db.add(new Person(3,"Piotr","Abacki"));
        db.add(new Person(4,"Ania","Walczak"));

      Consumer<Person> consumer=  person -> System.out.println(person.getLastName());

       Optional<Person> personOpt1=db.findById(2);
       personOpt1.ifPresent(PersonTest::printLastName);


        Optional<Person> personOpt2=db.findById(2);
        personOpt2.ifPresent(consumer);
        personOpt2.ifPresentOrElse(
               PersonTest::printLastName,
                ()-> System.out.println("Brak obiektu o wksazanym id")

        );


        String lastNameById = db.findLastNameById(33);
        System.out.println(lastNameById);


    }

    private static void printLastName(Person person){
        System.out.println(person.getLastName());
    }

}
