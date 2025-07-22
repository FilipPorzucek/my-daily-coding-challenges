public class PartTime extends Employee{

    int hours;
    public PartTime(String firstName, String lastName, int salary,int hours) {
        super(firstName, lastName, salary);
        this.hours=hours;
    }

    double monthSalary(){

        return getSalary()*hours;
    }
    @Override
    public String toString() {
        return getFirstName()+" " +lastName+" "+ "Stawka godzinowa"+salary+" "+"Roczna wypłata"+yearSalary()+"Miesięczna wypłata"+monthSalary();
    }

    @Override
    double yearSalary() {
        return monthSalary()*12;
    }
}
