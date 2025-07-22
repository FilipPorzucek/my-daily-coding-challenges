import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class app {
    public static void main(String[] args) {
        Random random=new Random();
        List<Integer> numbers=new ArrayList<>();
        generate(numbers,10,()->random.nextInt(1000));

        Supplier<Integer> randomNumberGenerator=()-> random.nextInt(100);


        List<Integer> integers = filterList(numbers, x -> x % 2 != 0);
        consumeNumbers(integers,n-> System.out.print(n+" "));
    }

    private static <T> List<T> filterList(List <T> list, Predicate<T> predicate) {
    List<T> result=new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t))
                result.add(t);
        }
return result;
    }

    private static <T> void generate(List <T> list,int limit,Supplier<T> sup) {
        for(int i=0;i<limit;i++){
            list.add(sup.get());
        }
    }


    private static <T> void consumeNumbers(List<T> list, Consumer<T> consumer) {
        for(T t:list){
            consumer.accept(t);
        }
    }
}
