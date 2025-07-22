package zad9;

public class Circle extends Shape{
    private int r;
    @Override
    public double area() {
        return 2*Math.PI*r;
    }
}
