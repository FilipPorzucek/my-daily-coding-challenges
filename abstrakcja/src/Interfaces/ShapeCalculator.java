package Interfaces;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ShapeCalculator {
    public static void main(String[] args) {
        ShapeData shapeData=new ShapeData();
        Shape shape=null;
        boolean readComplete=false;

        while (!readComplete){
            try {
                printOptions();
                shape=shapeData.createShape();
                readComplete=true;
            }catch (NoSuchElementException e){
                System.out.println("Wybrana opcja nie istnieje");
            }finally {
                shapeData.clearBuffer();
            }
            System.out.println(shape);
        }
        shapeData.closeScanne();
    }

    private static void printOptions() {
        System.out.println("Wybierz figure");
        System.out.println("Prostokąt");
        System.out.println("Trójkąt");
        System.out.println("Koło");
    }
}
