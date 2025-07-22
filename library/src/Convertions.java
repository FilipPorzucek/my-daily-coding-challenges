import java.util.Random;

import java.util.Random;

public class Convertions {
    public static void main(String[] args) {


        Random rand=new Random();
        int x=rand.nextInt(10);
        int y=rand.nextInt(10);
        System.out.println("x="+x+" "+"y="+y);

        boolean result= x>y;
        System.out.println("czy x jest wiekszy niz y ?"+" "+result);

        int b=x*2;
        result=b>y;
        System.out.println(result);
        int c=x+3;
        int d=x-2;
        result=y<c&&y>d;
        System.out.println(result);

        int e=x*y;
        result=e%2==0;
        System.out.println(e);
        System.out.println("czy iloczyn jest parzysty?"+result);






    }
}
