import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Wpisuj liczby any je zsumowac");
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Wpisujac exit zakonczysz dzialanie programu i zsumujesz liczby");
        String option="";
        while (!option.equals("exit")) {
            System.out.println("Podaj liczbe lub wpisz exit");
            option=sc.nextLine();
            if(!option.equals("exit")){
                int number= Integer.parseInt(option);
                list.add(number);
            }
        }
        int sum=0;
        for (Integer i : list) {
            sum+=i;
        }
        System.out.println(sum);
    }



}
