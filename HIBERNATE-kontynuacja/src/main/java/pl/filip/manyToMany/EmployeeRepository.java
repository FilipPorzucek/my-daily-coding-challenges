package pl.filip.manyToMany;

import org.hibernate.Session;
import pl.filip.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeRepository {
    List<Employee> insertData(final List<Employee> employees){
        try( Session session= HibernateUtil.getSession()){
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            System.out.println("######BEFORE INSERT\n----------");
            employees.forEach(session::persist);
            System.out.println("######AFTER INSERT\n----------");
            session.getTransaction().commit();
            return employees;

        }

    }

    List<Employee> listEmployees(){
        try(Session session=HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query="SELECT employee FROM Employee employee";
            List<Employee> employees=session.createQuery(query, Employee.class).list();
            return employees;
        }
    }

    Optional<Employee> getEmployee(Integer employeeId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Employee.class,employeeId));
        }
    }

    void updateEmployee(Integer employeeId,Project newProject){
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
             session.beginTransaction();
            Employee employee=session.find(Employee.class,employeeId);
            employee.getProjects().add(newProject);
            session.getTransaction().commit();
        }
    }

    void deleteEmployee(Integer employeeId){
         try(Session session=HibernateUtil.getSession()) {
             if (Objects.isNull(session)){
                 throw new RuntimeException("Sesiion is null");
             }
           session.beginTransaction();
             session.remove(session.find(Employee.class,employeeId));
             session.getTransaction().commit();
         }
    }

    void deleteAll(){
        try(Session session=HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sesiion is null");
            }
            session.beginTransaction();
            String query="select employee from Employee employee";
            session.createQuery(query, Employee.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }


}
