public class QuestionEvaluatorFacade {
    private static final QuestionEvaluator[] EVALUATORS={
            new MathAddEvaluator(),
            new TodaQuestionEvaluator(),
            new TextCountEvaluator()
    };
    static String evaluate(String input){
        for (QuestionEvaluator evaluator : EVALUATORS) {
            if(evaluator.match(input)){
                return evaluator.evaluate(input);
            }
        }
        throw new IllegalArgumentException("QuestionEvaluator for your input not found");
    }


}
