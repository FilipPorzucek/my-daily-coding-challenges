import java.util.Arrays;

public class CounterProcesoor implements StringTemplate.Processor<Integer,RuntimeException>{
    public static final CounterProcesoor COUNTER=new CounterProcesoor();

    @Override
    public Integer process(StringTemplate template) throws RuntimeException {
        String interpolateText = template.interpolate();
        return (int) Arrays.stream(interpolateText.split(" "))
                .filter(s->!s.isEmpty())
                .count();


    }
}
