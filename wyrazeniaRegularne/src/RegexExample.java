import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        //\w+@[a-z0-9]+\.[a-z]{2,}
   //  String text="Jan ma 15 lat.Dodatkowo Jan lubi piłkę nożną";
       // String replace = text.replace("Jan", "Piotr");
       // String replaceAll = text.replaceAll("Jan", "Karol");
      //  System.out.println(replace);
     //   System.out.println(replaceAll);

        String contact="Numer kontaktowy do supportu: 123-476-789";
        String conractDisplay = contact.replaceAll("\\d{3}-\\d{3}-\\d{3}", "***-***-***");
        System.out.println(conractDisplay);


    }
}
