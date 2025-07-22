import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonOperator {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("Kasia");
        names.add("Basia");
        names.add("Janek");
        names.add("Grzegorz");
        names.add("Damian");


        names.sort(String::compareToIgnoreCase);
       names.forEach(System.out::println);




    }
}
