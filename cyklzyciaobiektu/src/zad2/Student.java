package zad2;

public class Student extends Person{
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Jestem studentem i moje id to"+studentId);
    }
}
