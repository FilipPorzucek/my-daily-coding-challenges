package Interfaces;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ShapeData {
    Scanner scanner=new Scanner(System.in);


    public void closeScanne(){
        scanner.close();
    }

    public Circle CircleData(){
        System.out.println("Podaj promien kola do obliczenia jeo pola i wymiaroww");
        double promien= scanner.nextDouble();
       return new Circle(promien);
    }


    public Rectangle RectangleData(){
        System.out.println("Podaj boki kwadratu do obliczenia jeo pola i wymiaroww");
        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
        return new Rectangle(a,b);
    }

    public Triangle TriangleData(){
        System.out.println("Podaj bok i wysokosc trójkąta do obliczenia jeo pola i wymiaroww");
        double bok=scanner.nextDouble();
        double wysokosc=scanner.nextDouble();
        return new Triangle(bok,wysokosc);
    }

    public Shape createShape() {
        int shapeType=scanner.nextInt();
        switch (shapeType){
            case 1:
                return RectangleData();

            case 2:
                return TriangleData();
            case 3:
                CircleData();
            default:
                throw new NoSuchElementException();
        }
    }

    public void clearBuffer() {
        scanner.nextLine();
    }
}
