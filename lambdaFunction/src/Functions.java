import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functions {
    public static void main(String[] args) {

        String[] firstNames={"Jan","Karol","Piotr","Andrzej"};
        String[] lastNames={"Abacki","Kowalski","Zalewski","Korzeniewski"};
        int[] ages={22,33,44,55};
        Random random=new Random();
        Supplier<Pearson> supplier=()->{
        String firstName=firstNames[random.nextInt(firstNames.length)];
        String lastName=lastNames[random.nextInt(lastNames.length)];
        int age=ages[random.nextInt(ages.length)];
        return new Pearson(firstName,lastName,age);
        };
        System.out.println(supplier.get());

        List <Pearson> people=generateRandomList(5,supplier);

        System.out.println("People:");
        consumeList(people,p-> System.out.println(p));

        consumeList(people,p -> p.setAge(p.getAge()+1));

        System.out.println("People age +1:");
        consumeList(people,p-> System.out.println(p));

        System.out.println("Tylko dorosli");
        List<Pearson> adults =filterByPredicate(people,(Pearson p)->p.getAge()>=18);
        consumeList(adults,pearson -> System.out.println(pearson) );

        System.out.println("Tylko Jany");
        List<Pearson> janPeople=filterByPredicate(people,(Pearson p)->p.getName().equals("Jan"));
        consumeList(janPeople,pearson -> System.out.println(pearson) );

        List<String> firstNames2 = converList(people, pearson -> pearson.getName());
        consumeList(firstNames2,pearson-> System.out.println(pearson));


    }

    private static <T,R>List<R> converList(List<T> list, Function<T,R> function){
    List<R> resultList=new ArrayList<>();
        for (T t : list) {
            R result = function.apply(t);
            resultList.add(result);
        }
return resultList;
    }

    private static List<String> getFirstNames(List<Pearson> people) {
        List<String> firstNames=new ArrayList<>();
        for (Pearson person : people) {
            firstNames.add(person.getName());
        }
        return firstNames;
    }


    private static <T> List<T> filterByPredicate(List<T> list,Predicate<T> predicate) {
        List<T> result=new ArrayList<>();
        for (T t : list) {
           if(predicate.test(t))
               result.add(t);
        }
return result;
    }



    private static<T> void consumeList(List<T> list,Consumer<T> consumer) {
        for(T t:list){
            consumer.accept(t);
        }
    }

    private static <T> List<T> generateRandomList(int elements,Supplier <T>supplier){
        List<T> result=new ArrayList<>();
        for (int i=0;i<elements;i++){
            result.add(supplier.get());
        }
        return result;
    }

}
