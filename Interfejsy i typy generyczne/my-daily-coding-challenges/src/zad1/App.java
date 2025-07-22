package zad1;

public class App {
    public static void main(String[] args) {
        Circle circle=new Circle();
        circle.setR(9);
        System.out.println(circle.Area());
        Rectangle rectangle=new Rectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(5);
        System.out.println(rectangle.Area());
    }
}
