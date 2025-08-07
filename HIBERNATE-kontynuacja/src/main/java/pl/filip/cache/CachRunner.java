package pl.filip.cache;


import pl.filip.HibernateUtil;

public class CachRunner {
    public static void main(String[] args) {
        EmployeeRepository employeeRepository=new EmployeeRepository();
        employeeRepository.deleteAll();
        employeeRepository.insertData1(ExampleData.someEmployee11());
        CachedEmployee employee = employeeRepository.insertData1(ExampleData.someEmployee22());
        employeeRepository.insertData1(ExampleData.someEmployee33());

        employeeRepository.l2c(employee.getEmployee_id());
        employeeRepository.l2c(employee.getEmployee_id());

        HibernateUtil.closeSessionFactory();


    }
}
