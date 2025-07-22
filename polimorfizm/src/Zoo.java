import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {


    Animal animal=null;

        Scanner scanner=new Scanner(System.in);
        System.out.println("Kot=1, Pies=2");
        int option=scanner.nextInt();
        if(option==1){
            animal=new Cat("Mruczek");
        }else if(option==2){
            animal=new Dog("Burek");
        }

        if(animal instanceof Dog){
            ((Dog)animal).bark();
        } else if (animal instanceof Cat) {
            ((Cat)animal).meow();

        }

    }
}