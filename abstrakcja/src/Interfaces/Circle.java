package Interfaces;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    public double calculateArea(){
        return Shape.PI*r*r;
    }

    public double calculatePerimeter(){

        return 2*Shape.PI*r;
    }

    @Override
    public String toString() {
         return "Pole"+calculatePerimeter()+"Obwod"+calculateArea();
    }
}
