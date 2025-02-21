import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodaQuestionEvaluator extends   QuestionEvaluator{
private final static Pattern PATTERN=Pattern.compile(
        "[Jj]aki dziś dzień tygodnia\\??"
);

    public TodaQuestionEvaluator() {
        super(PATTERN);
    }


    @Override
    protected String evaluateQuestion(String input, Matcher matcher) {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String displayDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.of("pl"));
        return "Dziś jest "+displayDay;
    }

}
