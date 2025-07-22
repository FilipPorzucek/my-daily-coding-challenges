import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SumNumbers {

   static Scanner scanner=new Scanner(System.in);
   private static final String EXIT="exit";
    public static void main(String[] args) {
        List<Double>numbers=new ArrayList<>();
        fillList(numbers);

       printData(numbers);
    }

    private static void printData(List<Double> numbers) {
        if(!numbers.isEmpty()){
            StringBuilder sb=new StringBuilder();
            double sum=0;
            for (Double n : numbers) {
                sb.append(n);
                sb.append("+");
                sum+=n;
            }
            sb.replace(sb.length()-1,sb.length(),"=");
            sb.append(sum);
            System.out.println(sb.toString());
        }
    }

    private static void fillList(List<Double> numbers) {
        System.out.println("Podaj liczbe");
        String input=scanner.nextLine();
        if(input.equalsIgnoreCase(EXIT))
            return;

        try{
          Double num= Double.valueOf(input);
            numbers.add(num);
        }catch (NumberFormatException e){
            System.err.println("Podano zly format");
        }
        fillList(numbers);
    }
}
