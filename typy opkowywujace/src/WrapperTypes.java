import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class WrapperTypes {

    public static void main(String[] args) {
         final String fileName ="numbers.txt";

    try(
            var fileReader=new FileReader(fileName);
            var bufferedReader=new BufferedReader(fileReader);
            ) {

       int a= Integer.parseInt( bufferedReader.readLine());
       int b=Integer.parseInt(bufferedReader.readLine());
       int c=Integer.parseInt(bufferedReader.readLine());
       BigInteger big1=new BigInteger(bufferedReader.readLine());
       BigInteger big2=new BigInteger(bufferedReader.readLine());

        System.out.println("a+b+c"+"="+(a+b+c));
        System.out.println(big1.add(big2));

    } catch (IOException e) {
        System.err.println("Blad");
    }

    }

}