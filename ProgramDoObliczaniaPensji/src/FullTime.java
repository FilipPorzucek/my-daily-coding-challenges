public class FullTime extends Employee{

    public FullTime(String firstName, String lastName, int salary) {
        super(firstName, lastName, salary);
    }

    @Override
    double yearSalary() {
        double bonus=getSalary()*0.05;
        return getSalary()*12+bonus;
    }
}
