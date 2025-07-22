import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDatabase {
    private List<Person> people=new ArrayList<>();

   void add(Person person){
        if (person==null)
            System.out.println("Cannot add ful reference");
        findById(person.getId()).ifPresent(p->{
            throw new IllegalArgumentException("Object with such is already exists");
       });



        people.add(person);
    }

 Optional<Person> findById(int id){
        for(Person person:people){
            if(person.getId()==id)
                return Optional.of(person);
        }
        return Optional.empty();
  }

  String findLastNameById(int id) {
     return findById(id)
              .map(Person::getLastName)
              .orElse("Anonim");

  }

}
