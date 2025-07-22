import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Operations operation = new Operations();
        Scanner sc = new Scanner(System.in);
        double firstNumb = 0;
        double secondNumb = 0;
        int options = 0;


        boolean readComplete = false;
        while (!readComplete) {
            try {
                System.out.println("Wprowadź pierwszą liczbe");
                firstNumb = sc.nextDouble();
                System.out.println("Wprowadź drugą liczbę");
                secondNumb = sc.nextDouble();
                System.out.println("Wybierz opcje");
                System.out.println("1:Odejmowanie");
                System.out.println("2: Dodawanie");
                System.out.println("3:Mnożenie");
                System.out.println("4:Dzielenie");
                options = sc.nextInt();
                readComplete = true;

            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono zle dane");
                sc.nextLine();
            }

        }
        switch (options) {
            case 1:

                operation.odejmowanie(firstNumb, secondNumb);
                break;
            case 2:
                operation.dodawanie(firstNumb, secondNumb);
                break;
            case 3:
                operation.mnożenie(firstNumb, secondNumb);
                break;
            case 4:
                if (secondNumb == 0) {
                    throw new ArithmeticException("Nie możesz dzielić przez 0");
                } else {
                    operation.dzielenie(firstNumb, secondNumb);
                }
                break;
            default:
                throw new UnknowOperatorException("Nie ma takiej opcji");


        }
    }
}

