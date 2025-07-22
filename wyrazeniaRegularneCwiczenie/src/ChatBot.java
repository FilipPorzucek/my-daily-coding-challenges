import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Cześć");
        System.out.println("W czym moge ci pomóc (\"koniec\" przerywa program)");
        boolean close=false;
        do {
            String input=scanner.nextLine();
            try {
                String result = QuestionEvaluatorFacade.evaluate(input);
                System.out.println(result);
            }catch (IllegalArgumentException e){
                if(input.equalsIgnoreCase("koniec")){
                    close=true;
                }else {
                    System.out.println("Niestety w tym ci nie pomoge");
                }
            }
        }while (close == false);

    }
}
