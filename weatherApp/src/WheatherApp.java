import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;

public class WheatherApp {
    private static final Scanner SCANNER=new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Map<LocalDate, Wheather> measurments = TemperatureReader.readMeasurments("weather.csv");
            LocalDate date=readDate();
            Wheather.Unit unit=readUnit();
            Wheather wheather = measurments.get(date);
            printWheather(wheather,unit);

        } catch (FileNotFoundException e) {
            System.err.println("Nie umozna odczytac pliku");
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }catch (DateTimeParseException e){
            System.err.println("Podano zly format daty");
        }
    }

    private static void printWheather(Wheather wheather, Wheather.Unit unit) {
        if(wheather==null){
            System.out.println("Brak pomiaru dla tej daty");
        }else {
            double minTemp=wheather.minTempAS(unit);
            double maxTemp=wheather.maxTempAS(unit);
            String temp="Minimalna temperatura dnia %s wynosiła %.2f%s,a maksymalna %.2f%s";
            System.out.println("Odnaleziony pomiar");
            System.out.printf(
                    temp,
                    wheather.data(),
                    minTemp,
                    unit.getUnitSign(),
                    maxTemp,
                    unit.getUnitSign()

            );

        }
    }

    private static Wheather.Unit readUnit() {
        System.out.println("W jakiej jednostce wyświetlić pomiary? (C / F)?");
        String input = SCANNER.nextLine();
        return Wheather.Unit.fromUnitSign(input);
    }

    private static LocalDate readDate() {
        System.out.println("Dane z którego dnia Cię interesują? (format yyyy-MM-dd)?");
        String input = SCANNER.nextLine();
        return LocalDate.parse(input,TemperatureReader.DATE_TIME_FORMATTER);

    }
}
