import java.util.Scanner;

public class ST {
    public static void main(String[] args) {

       Scanner sc=new Scanner(System.in);
        System.out.println("Wcisniej enter aby rzucic kostka");
sc.nextLine();
String diceSide=Dice.roll();
        System.out.println(diceSide);


    }
}
