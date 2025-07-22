import java.util.Scanner;

public class App {
    private static final Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Wprowadź informacje o osobie");
        Person person=createPearson();
        System.out.println("Wybierz format wyswietlenia danych: XML/JSON");
        String choose=sc.nextLine();
        if (choose.equalsIgnoreCase("XML"))
            System.out.println(person.toXML());
        else if (choose.equalsIgnoreCase("JSON")){
            System.out.println(person.toJson());
        }else System.out.println(person);

    }

    private static Person createPearson() {
        System.out.println("Podaj imie");
        String firstname=sc.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName=sc.nextLine();
        System.out.println("Podaj wiek");
        int age= sc.nextInt();
        sc.nextLine();
        return new Person(firstname,lastName,age);

    }
}
