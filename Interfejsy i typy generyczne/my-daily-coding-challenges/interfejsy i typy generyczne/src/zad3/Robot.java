package zad3;

public class Robot implements Imovable,Irotatable{
    @Override
    public void move() {
        System.out.println("Robot sie poruszyl");
    }

    @Override
    public void rotate() {
        System.out.println("Robot sie obrocil");
    }
}
