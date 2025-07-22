import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TemperatureReader {
    static final DateTimeFormatter DATE_TIME_FORMATTER=DateTimeFormatter.ofPattern("yyyy-MM-dd");
   private static final String SEPARATOR=";";

   static Map<LocalDate, Wheather> readMeasurments(String filePath) throws FileNotFoundException {
      Scanner scanner=new Scanner(new File(filePath));
      Map<LocalDate, Wheather> result=new HashMap<>();
      while (scanner.hasNextLine()){
         String nextLine=scanner.nextLine();
         Wheather wheather=createDailyTemperature(nextLine);
         result.put(wheather.data(),wheather);
      }
      return result;
   }

   private static Wheather createDailyTemperature(String text) {


      String[] tokens = text.trim().split(SEPARATOR);
      try {
         return new Wheather(
                 LocalDate.parse(tokens[0], DATE_TIME_FORMATTER),
                 Double.parseDouble(tokens[1]),
                 Double.parseDouble(tokens[2]),
                 Wheather.Unit.valueOf(tokens[3])
         );
      }catch (Exception e){
         throw new IllegalArgumentException("Nie mozna pzretworzyc wiersza"+text);
      }

   }

}
