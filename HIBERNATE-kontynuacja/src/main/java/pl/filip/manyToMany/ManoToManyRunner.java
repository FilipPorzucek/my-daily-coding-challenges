package pl.filip.manyToMany;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

public class ManoToManyRunner {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository=new EmployeeRepository();

        employeeRepository.deleteAll();

        List<Employee> employeesCreated=createEmployees(employeeRepository);

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("List: "+employee));

//        System.out.println("Employee 1: "+employeeRepository.getEmployee
//                (employeesCreated.get(employeesCreated.size()-1).getEmployee_id()));
//        System.out.println("Employee 2"+ employeeRepository.getEmployee
//                (employeesCreated.get(employeesCreated.size()-2).getEmployee_id()));
//
//        updateEmployees(employeeRepository,employeesCreated);
//
//        employeeRepository.listEmployees().forEach(
//                employee -> System.out.println("Employee list"+employee)
//        );
//        employeeRepository.deleteEmployee(employeesCreated.get(employeesCreated.size()-2).getEmployee_id());
//
//        employeeRepository.listEmployees().forEach(
//                employee -> System.out.println("New list "+ employee)
//        );
//
//

    }

    private static void updateEmployees(final EmployeeRepository employeeRepository,final List<Employee> employeesCreated) {
        Employee employeToBeUpdated=employeesCreated.get(employeesCreated.size()-1);
        Project project=Project.builder().name("Performance optimization")
                .deadline(OffsetDateTime.now())
                .build();
        employeeRepository.updateEmployee(employeToBeUpdated.getEmployee_id(), project);
        System.out.println("Employee update"+employeeRepository.getEmployee(employeesCreated.get(employeesCreated.size()-1).getEmployee_id()));
    }

    private static List<Employee> createEmployees(final EmployeeRepository employeeRepository) {
        Project project= ExampleData.seomeProject1();
        Project project2= ExampleData.seomeProject2();
        Employee employee1=ExampleData.someEmployee1();
        Employee employee2=ExampleData.someEmployee2();
        Employee employee3=ExampleData.someEmployee3();
        employee1.setProjects(Set.of(project,project2));
        employee2.setProjects(Set.of(project2));
        employee3.setProjects(Set.of(project));
        return employeeRepository.insertData(List.of(employee1,employee2,employee3));

    }


}
