import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] numbers=new int[2];
        boolean error=true;
        do {
            try {
                System.out.println("Podaj liczbe");
                numbers[0]=sc.nextInt();
                System.out.println("Podaj druga liczbe");
                numbers[1]=sc.nextInt();
                System.out.println("Ktorą z liczb chciałbyś wyświtlić");
                System.out.println("Liczba "+numbers[sc.nextInt()-1]);
                error=false;
            } catch (InputMismatchException e) {
                System.out.println("Nie poprawna wartość");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Mialo byc jedn lub dwa");
            } finally {
                sc.nextLine();
            }
        }while (error);

        sc.close();
    }

}
