import java.util.List;
import java.util.function.Consumer;

public class ComputerMethods {
    public static void main(String[] args) {



        List<Computer> computers=List.of(
                new Computer("Lenovo",300,45),
                new Computer("HP",3200,66),
                new Computer("Apple",3400,78),
                new Computer("Asus",200,42)
        );



        consume(computers, Computer::overclock);
        consume(computers, ComputerMethods::printComputerWithTemperature);

    }

    private static void printComputerWithTemperature(Computer computer){
        String textToPrint=computer.getName()+" "+computer.getCpu();
        if(computer.getTemperature()<50)
            textToPrint+=" /cold";
        else textToPrint+=" /!hot";
        System.out.println(textToPrint);
    }

    private static void consume(List<Computer> computers, Consumer<Computer> consumer){
        for (Computer computer : computers) {
          consumer.accept(computer);
        }
    }

}
