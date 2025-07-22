import java.util.Arrays;
import java.util.Objects;

public class DataStore {
    private final static int MAX_COMPUTER = 100;
    private Computer[] computers = new Computer[MAX_COMPUTER];
    private int computerNumber = 0;


    public void add(Computer computer) {
        if (computerNumber < MAX_COMPUTER) {

            computers[computerNumber] = computer;
            computerNumber++;

        } else {
            System.out.println("Nie ma miejsca w magazynie");
        }
    }


    public void print() {
        for (Computer computer : computers) {
            if (computer != null) {
                System.out.println(computer.toString());
            }
        }

    }

    int checkAvailability(Computer find) {
        if (find == null)
            return 0;

        int count = 0;
        for (int i = 0; i < computerNumber; i++) {
            if (find.equals(computers[i]))
                count++;
        }
        return count;
    }
    }






