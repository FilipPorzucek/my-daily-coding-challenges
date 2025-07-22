import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        Integer[] numbers={12,45,22,23,43,543,33,1,3,10,45,38,12,45,2,3,9,18,92,223};
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return -(Integer.compare(o1,o2));


            }
        });
        System.out.println("Posortowana");
        System.out.println(Arrays.toString(numbers));
    }
}
