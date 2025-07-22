import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj imie");
        String name=scanner.nextLine();

        Student student=new Student(name,"Bielawski",12);
        student.PrzedstawSie();
    }


}
