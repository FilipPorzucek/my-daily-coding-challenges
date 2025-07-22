package vehicle;

public class Test {
    public static void main(String[] args) {
        Car car1=new Car();
        car1.setDoors(4);
        car1.setWheels(4);
        car1.setEngine(new Engine (120,"Diesel"));

        car1.setFuel(40);
        car1.printInfp();



    }
}
