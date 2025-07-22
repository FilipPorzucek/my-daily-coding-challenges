import java.io.*;
import java.util.Arrays;

public class App {
    public static String FILE="C:\\Users\\Filip\\Desktop\\javaStart\\wc2\\src\\text";
    public static void main(String[] args) {

        Flat[] flats=FlatReader.readOffers(FILE);
        Arrays.sort(flats);
        for (Flat flat : flats) {
            System.out.println(flat);
        }
    }
}
