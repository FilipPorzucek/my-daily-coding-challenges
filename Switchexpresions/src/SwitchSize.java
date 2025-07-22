import java.util.Scanner;

public class SwitchSize {
    public static void main(String[] args) {
   Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj rozmiar S M L lub XL");
       String shortSize= scanner.nextLine();



     String size= switch (shortSize){
           case "S"->"mały";

           case "M"-> "Średni";

           case "L"->"Duży";

           case "XL"-> "Bardzo duży";

           default-> "nieznany";
       };
        System.out.println("Wybrano rozmiar"+size);
    }
}
