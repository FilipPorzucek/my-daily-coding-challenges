
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbe a:");
        double a=scanner.nextDouble();
        System.out.println("Podaj drugą liczbę b:");
        double b=scanner.nextDouble();



        Calculate calculate=new Calculate();

        System.out.println("Wybierz rodzaj operacji:");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Option 4");
        int option=scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("dodawanie");
                calculate.add(a,b);
                break;
            case 2:
                System.out.println("Odejmowanie");
            calculate.subtraction(a,b);
            break;
            case 3:
                System.out.println("Mnożenie");
                calculate.multiplication(a,b);
                break;
            case 4:
                System.out.println("Dzielenie");
                calculate.division(a,b);
                break;

            default:
                System.out.println("dzielenie");
                System.out.println("Nie ma takiej opcji");

        }

    }
}
