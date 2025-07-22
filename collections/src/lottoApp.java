import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lottoApp {
    public static void main(String[] args) {
Lotto lotto=new Lotto();
        System.out.println("Witamy w programie lott");
        List<Integer> userNumbers=readNumberFromUser();
        int result = lotto.checkResults(userNumbers);
        System.out.println("Liczba trafien to" +  result);




    }

    private static List<Integer> readNumberFromUser() {
        Scanner sc=new Scanner(System.in);
        List<Integer> numbers=new ArrayList<>();

        for (int i=0;i<Lotto.MAX_NUMBERS;i++){
            System.out.println("Podaj liczbe");
            int nextNumber= sc.nextInt();
            numbers.add(nextNumber);
        }

        return numbers;


    }
}
