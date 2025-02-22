import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class  QuestionEvaluator {
    private final Pattern pattern;

    public QuestionEvaluator(Pattern pattern) {
        this.pattern = pattern;
    }

     String evaluate(String input){
         Matcher matcher = pattern.matcher(input);
         if(!matcher.matches()) {
             throw new IllegalArgumentException("No match");
         }
         return evaluateQuestion(input,matcher);
     }

    protected abstract String evaluateQuestion(String input,Matcher matcher);


    boolean match(String input){
     return pattern.matcher(input).matches();
  }

}
