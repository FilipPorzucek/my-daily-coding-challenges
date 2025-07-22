import java.io.*;
import java.util.Scanner;

public class FlatReader {
    private static final int OFFERS_IN_FILE=10;

    static Flat[] readOffers(String fileName) {
        Flat[] flat = new Flat[OFFERS_IN_FILE];
        try(Scanner scanner=new Scanner(new File(fileName))) {
            scanner.nextLine();
            for (int i = 0; i < OFFERS_IN_FILE; i++) {
                flat[i]=createOffer(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nieznaleziono pliku");
        } ;
        return flat;
    }

    private static Flat createOffer(String line) {
        String[] data = line.split(";");
        return new Flat(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2]));


    }

}
