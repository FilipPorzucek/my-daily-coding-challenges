import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathAddEvaluator extends QuestionEvaluator{

    private static final Pattern PATTERN=Pattern.compile(
          "[Jj]aki jest wynik dodawania (?<a>\\d{1,}) do (?<b>\\d{1,})\\??"
    );

    public MathAddEvaluator() {
        super(PATTERN);
    }

    @Override
    protected String evaluateQuestion(String input,Matcher matcher) {
        int a=Integer.parseInt(matcher.group("a"));
        int b=Integer.parseInt(matcher.group("b"));
        int sum=a+b;

        return "Wynik dodawania %d+%d=%d,".formatted(a,b,sum);
    }


}
