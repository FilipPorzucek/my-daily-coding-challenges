import java.util.Random;
import java.util.Scanner;

public class Moneta {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();



        System.out.println("wybierz jedna z dwoch opcji: ");
        System.out.println("1-Orzeł");
        System.out.println("0-reszka");
        int choice=scanner.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Wybrałeś reszke");
                break;

            case 1:
                System.out.println("Wyrałeś orła");
                break;

        }

        int losuj= random.nextInt(2);
        System.out.println("Wylosowanan opcja to" +losuj);
        if(choice==losuj){
            System.out.println("Wygrałeś brawo");
        }else {
            System.out.println("Przegrałeś");
        }
    }
}
