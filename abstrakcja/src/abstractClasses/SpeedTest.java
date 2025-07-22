package abstractClasses;

public class SpeedTest {
    public static void main(String[] args) {
        Vehicle car=new Car();
        Vehicle plane=new Plane();


        car.speedUp();
        plane.speedUp();


        System.out.println("Prędkość samochodu "+car.getSpeed());
        System.out.println("Prędkość samolotu "+plane.getSpeed());
    }
}
