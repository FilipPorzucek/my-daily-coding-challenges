package pl.filip;

import java.math.BigDecimal;

public class EmployeeExample {
    public static void main(String[] args) {


        EmployeeRepository employeeRepository=new EmployeeRepository();
        employeeRepository.deleteAll();
        Employee employee1 = employeeRepository.insert(EmployeeData.someEmployee1());
        Employee employee2 = employeeRepository.insert(EmployeeData.someEmployee2());
        Employee employee3 = employeeRepository.insert(EmployeeData.someEmployee3());

        System.out.println("Employee 1"+ employeeRepository.getEmployee(employee1.getEmployeeId()));
        System.out.println("Employee 2"+ employeeRepository.getEmployee(employee2.getEmployeeId()));

        employeeRepository.updateEmployee(employee3.getEmployeeId(),new BigDecimal("99999.213"));
        System.out.println("### Emplyee updated "+employeeRepository.getEmployee(employee3.getEmployeeId()));

        employeeRepository.listEmployee()
                .forEach(employee -> System.out.println("###Employee "+employee));

        employeeRepository.deleteEmployee(employee2.getEmployeeId());

        employeeRepository.listEmployee()
                .forEach(employee -> System.out.println("###Employee "+employee));

        HibernateUtil.closeSessionFactory();

    }
}
