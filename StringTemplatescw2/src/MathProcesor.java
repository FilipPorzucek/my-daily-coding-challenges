import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathProcesor implements StringTemplate.Processor<BigInteger, IllegalArgumentException> {
    public static final MathProcesor MATH=new MathProcesor();
        private static final Pattern PATTERN=Pattern.compile
                ("(?<operandA>\\d+)\\s*(?<operator>[+*/-])\\s*(?<operandB>\\d+)");

    @Override
    public BigInteger process(StringTemplate template) {
        String interpolatedTemplate = template.interpolate();
        Matcher matcher = PATTERN.matcher(interpolatedTemplate);
        if(!matcher.matches()){
            throw new IllegalArgumentException(STR."Procesor nie może obsłużyć działania \{interpolatedTemplate}");
        }
        BigInteger a = new BigInteger(matcher.group("operandA"));
        BigInteger b = new BigInteger(matcher.group("operandB"));
        String operator=matcher.group("operator");
        return switch (operator){
            case "+"->a.add(b);
            case "-"->a.subtract(b);
            case "*"->a.multiply(b);
            case "/"->a.divide(b);
            default -> throw new IllegalArgumentException(STR."Operator \{operator} nie jest obsługiwany");
        };


    }
}
