package adpp;

import data.Point;
import logic.pointController;

import java.util.Scanner;

public class pointAplication {
    public static void main(String[] args) {


        Point point1 = new Point(10, 20);
        pointController pc = new pointController();


        int option=2;

        System.out.println("X to"+point1.getX()+"Y to"+point1.getY());
        switch (option) {
            case 1 -> {
                System.out.println("Przesun x o 1 w prawo");
                pc.addX(point1);
                System.out.println("X to"+point1.getX()+"Y to"+point1.getY());

            }
            case 2 -> {
                System.out.println("Przesun x o 1 w lewo");
                pc.minusX(point1);
                System.out.println("X to"+point1.getX()+"Y to"+point1.getY());

            }
            default -> {
                System.out.println("Niepoprawna opcja");
            }

        }
    }

}
