import org.w3c.dom.css.Counter;

import java.util.List;

import static java.lang.StringTemplate.RAW;
import static java.util.FormatProcessor.FMT;

public class Test {
    public static void main(String[] args) {
        String firstName="Ala";
        String animal="kota";
        System.out.println(CounterProcesoor.COUNTER."Ala ma kota");
        System.out.println(CounterProcesoor.COUNTER."\{firstName} ma \{animal}");
        System.out.println(CounterProcesoor.COUNTER."a");
        System.out.println(CounterProcesoor.COUNTER."");
        System.out.println(CounterProcesoor.COUNTER."  ");








    }
}
