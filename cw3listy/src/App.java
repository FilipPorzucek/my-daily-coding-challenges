import java.util.ArrayList;
import java.util.Scanner;

public class App {
   static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Integer> numbers=new ArrayList<>();
        fillList(numbers);
        System.out.println(numbers);
        System.out.println("Ilosc poprawnych liczb to"+numbers.stream().toArray().length);
        addedNumbers(numbers);
        System.out.println("Suma tych liczb to"+addedNumbers(numbers));
        averageNumbers(numbers);

    }

    private static void averageNumbers(ArrayList<Integer> numbers) {
        Integer length=numbers.stream().toArray().length;
        Integer sum=0;
        Integer equal=0;
        for (Integer number : numbers) {
            sum+=number;
             equal=sum/length;
        }
        System.out.println("Ich srednia to"+equal);
    }

    private static Integer addedNumbers(ArrayList<Integer> numbers) {
        Integer sum=0;
        for (Integer number : numbers) {
            sum+=number;

        }
        return sum;
    }

    private static void fillList(ArrayList<Integer> numbers) {
        System.out.println("Podaj lizcby nieujemne oraz podzielne przez 5");
        int input=scanner.nextInt();
        while (input>0 && input%5==0){
            System.out.println("Podaj lizcby nieujemne oraz podzielne przez 5");
           Integer num=Integer.valueOf(input);
           numbers.add(num);
           input=scanner.nextInt();
       }
        System.out.println("Podano niepoprawną liczbę. Program zakończony.");

    }
}
