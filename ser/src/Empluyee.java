public class Empluyee extends Person{
double salary;

    public Empluyee(String firstName, String lastName,double salary) {
        super(firstName, lastName);
        this.salary=salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+"wypłata"+salary;
    }
}
