import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Wybierz szklanke-1,łyżke-2 lub łyżeczke-3");
        int option=scanner.nextInt();
        System.out.println("Wpisz ilosc");
        int ilosc= scanner.nextInt();
        switch (option){
            case 1:
                Student.cup(ilosc);
                break;
            case 2:
                Student.spoon(ilosc);
                break;
            case 3:
                Student.spoony(ilosc);
                break;
        }




    }
}
