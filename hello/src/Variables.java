package hello.src;

public class Variables {
    public static void main(String[] args){
        var firstName="Jan";

        int age=25;
        double height=180.5;
       final  String pesel="1234567";


    System.out.println(firstName+ " " +"ma"+" "+age+" "+" lat");
    System.out.println("Pan Jan ma pesel" +" "+pesel);
    System.out.println("Jan ma "+height+" wzrostu");
    System.out.println("Jesli urosnie o 5cm to bedzie mial"+" "+(height+5)+"cm");

        firstName="Krzysztof";
    System.out.println("Imię po zmianie to"+" "+firstName);

    }
}
