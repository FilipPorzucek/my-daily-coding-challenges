package Interfaces;

public class Rectangle implements Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double calculateArea(){
        return a*b;
    }

    public double calculatePerimeter(){
        return 2*a+2*b;
    }

    @Override
    public String toString() {
        return "Pole"+calculatePerimeter()+"Obwod"+calculateArea();
    }
}
