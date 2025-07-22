package zad5;

public class App {
    public static void main(String[] args) {
        Container<Integer>number=new Container<>();
        number.setValue(32);
        Container<String>string=new Container<>();
        string.setValue("Joł");

        number.defaultValue();
        string.defaultValue();
    }




}
