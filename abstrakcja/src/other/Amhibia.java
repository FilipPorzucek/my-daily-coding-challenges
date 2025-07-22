package other;

public class Amhibia implements Car,Boat{

    @Override
    public void printName() {
        System.out.println("Amphibia to troche:");
        Car.super.printName();
        System.out.println("a troche");
        Boat.super.printName();

    }
}
