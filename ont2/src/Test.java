import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Podaj naps 1");
        String word1= sc.nextLine();
        System.out.println("Pdaj napis 2");
        String word2=sc.nextLine();

        word1EqualsWord2(word1,word2);

    }

    private static void word1EqualsWord2(String word1, String word2) {
        if (word1 != null || word2 != null) {



        char[] word1Array=word1.toUpperCase().toCharArray();
            char[] word2Array=word2.toUpperCase().toCharArray();

            Arrays.sort(word1Array);
            Arrays.sort(word2Array);

            if(Arrays.equals(word1Array,word2Array)){
                System.out.println("Napisy sa takie same");
            }else System.out.println("sa rozne");

        }else if(word1==null && word2==null){
            System.out.println("Napisy sa takie same");
        }else throw new NullPointerException("Podaj naips");
    }
}
