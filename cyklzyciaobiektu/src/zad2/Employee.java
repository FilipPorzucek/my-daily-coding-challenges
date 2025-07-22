package zad2;

public class Employee extends Person{
    public String position;

    public Employee(String position) {
        this.position = position;
    }

    public Employee(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Moje stanowisko to" +position);
    }
}
