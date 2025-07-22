package zad2;

public class App {
    public static void main(String[] args) {
        Employee employee=new Employee("Jacek",22,"lekarz");
        Person person=employee;
        person.print();
        Student student=new Student("Filip",19,"45555");
        student.print();
    }
}
