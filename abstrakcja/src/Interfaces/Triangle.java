package Interfaces;

public class Triangle implements Shape {
    private double h;
    private double a;

    public Triangle(double h, double a) {
        this.h = h;
        this.a = a;
    }

    public double calculateArea(){
        return a*a*a;
    }
    public double calculatePerimeter(){
        return a*h;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Pole"+calculatePerimeter()+"Obwod"+calculateArea();
    }
}
