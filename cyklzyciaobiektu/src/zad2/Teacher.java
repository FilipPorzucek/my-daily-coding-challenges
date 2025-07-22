package zad2;

public class Teacher extends Person{
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Jestem nauczycielem"+subject);
    }
}
