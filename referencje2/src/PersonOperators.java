import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

class PersonOperators {

    private static  String[] firstNames = {"Jan", "Karol", "Piotr", "Andrzej"};
    private static String[] lastNames = {"Abacki", "Kowalski", "Zalewski", "Korzeniewski"};
    private static  int[] ages = {22, 33, 44, 55};

    public static void main(String[] args) {

        PersonSupplier supplier = Person::new;
        List<Person> people = generateRandomList(5, supplier);
        consumeList(people, System.out::println);
    }

    private static  List<Person> generateRandomList(int elements, PersonSupplier supplier) {
        List<Person> result = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            result.add(supplier.get(firstNames,lastNames,ages));
        }
        return result;
    }

    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}