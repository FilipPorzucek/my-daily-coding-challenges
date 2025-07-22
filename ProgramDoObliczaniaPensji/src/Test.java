public class Test {
    public static void main(String[] args) {
       Employee[] employees=createEmplyess();
       printEmployees(employees);

       double totalMonthlySalaries=totalMonthlySalaries(employees);
        System.out.println(totalMonthlySalaries);
    }

    private static double totalMonthlySalaries(Employee[] employees) {
        double totalMonthlySalaries=0;
        for (Employee employee:employees){
totalMonthlySalaries+=employee.getSalary();
        }
        return  totalMonthlySalaries;
    }


    private static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());  // Wywołuje toString() każdego obiektu
        }
    }


    private static Employee[] createEmplyess() {
        Employee[] employees=new Employee[2];
        employees[0]=new FullTime("Jacek","Kowalski",4500);
        employees[1]=new PartTime("Monika","Rozalska",80,32);
        return  employees;
    }


}
