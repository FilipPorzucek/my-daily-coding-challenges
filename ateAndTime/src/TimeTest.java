import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TimeTest {
    public static void main(String[] args) throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in)) {

            LocalDate localDate = getLocalDate(scanner);
            LocalDate localDate2 = getLocalDate(scanner);
            System.out.println(localDate2);

            Period between = Period.between(localDate, localDate2);
            extracted(localDate, localDate2);


            System.out.println(between.getYears() + "lat " + " " + between.getMonths() + "miesiecy" + " " + between.getDays() + "dni");


        }
    }
    private static void extracted(LocalDate localDate, LocalDate localDate2) {
        if(localDate.isAfter(localDate2)){
            System.out.println("pierwsza data jest pozniejsza");
        } else if (localDate2.isAfter(localDate)) {
            System.out.println("Druga data jest pozniejsza");

        }else System.out.println("daty sa takie same");
    }

    private static LocalDate getLocalDate(Scanner scanner) {
        System.out.println("Podaj pierwsza date");
        System.out.println("Podaj rok");
        int year= scanner.nextInt();
        System.out.println("Podaj miesiac");
        int month= scanner.nextInt();
        System.out.println("Podaj dzien");
        int day= scanner.nextInt();


        LocalDate localDate = LocalDate.of(year,month,day);
        System.out.println(localDate);
        return localDate;
    }
}
