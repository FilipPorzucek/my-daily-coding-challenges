package zad15;

import zad9.Shape;

public class Emloyee {
    public String name;
    public String position;



    public static Emloyee CreateMenager(String name, String position){
        System.out.println(name+" "+position);
        return new Emloyee();

    }

}
