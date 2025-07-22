abstract class Employee {
    int salary;
    private String firstName;
    String lastName;


    public Employee( String firstName, String lastName,int salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;

    }

   abstract double yearSalary();

    @Override
    public String toString() {
        return firstName+" " +lastName+" "+ "wyplata "+salary+" "+"Roczna wyplata "+yearSalary();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstaName(String firstaName) {
        this.firstName = firstaName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName;
    }


}
