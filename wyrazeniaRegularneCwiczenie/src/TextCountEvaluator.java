import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCountEvaluator extends QuestionEvaluator {
    private static final Pattern PATTERN=Pattern.compile(
            "[Ii]le znaków ma tekst \"(?<text>.*)\"\\??"
    );

    public TextCountEvaluator() {
        super(PATTERN);
    }


    @Override
    protected String evaluateQuestion(String input, Matcher matcher) {
        String text = matcher.group("text");
        int textLength = text.length();
        int whiteSpace = text.replaceAll("\\S", "").length();
        int nonWhiteSpace=textLength-whiteSpace;
        return "Tekst ma %d znaków(czarne %d, białe  %d)"
                .formatted(textLength,whiteSpace,nonWhiteSpace);
    }


}
