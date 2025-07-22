import java.util.Random;
public class Dice {

    int number;




    Dice(){
        Random random=new Random();
        int randomNumber= random.nextInt(6)+1;
       number=randomNumber;
    }
    Dice(int a){
        number=a;
    }

    void roll(){
        Random random=new Random();
        int randomNumber= random.nextInt(6)+1;
        number=randomNumber;
    }
    void printInfo(){
        System.out.println("Liczba oczek to"+number);
    }


}


