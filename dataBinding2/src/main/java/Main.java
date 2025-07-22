import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        IntegerProperty first=new SimpleIntegerProperty();
        IntegerProperty second=new SimpleIntegerProperty();
        second.bind(first);
        System.out.println("Podaj pieewsza liczbe");
        first.set(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Liczba druga to"+second.get());

    }
}
