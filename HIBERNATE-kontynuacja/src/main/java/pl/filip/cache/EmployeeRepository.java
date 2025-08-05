package pl.filip.cache;

import org.hibernate.Session;
import pl.filip.HibernateUtil;

import java.util.Objects;

public class EmployeeRepository {

     CachedEmployee insertData1(final CachedEmployee employee) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(employee);

            session.getTransaction().commit();
           return employee;

        }
    }

    void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query="select employee from Employee employee";
            session.createQuery(query, CachedEmployee.class).list().forEach(session::remove);

          session.getTransaction().commit();

        }
    }

    void l1c(int employeeId){
        try (Session session=HibernateUtil.getSession()){
            if (Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            CachedEmployee e1 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("####E1 %s %s%n", e1.getName(), e1.getSurname());

            CachedEmployee e2= session.find(CachedEmployee.class, employeeId);
            System.out.printf("####E1 %s %s%n", e2.getName(), e2.getSurname());

            session.evict(e1);

            CachedEmployee e3 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("####E1 %s %s%n", e3.getName(), e3.getSurname());

            CachedEmployee e4 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("####E1 %s %s%n", e4.getName(), e4.getSurname());

            session.clear();

            CachedEmployee e5 = session.find(CachedEmployee.class, employeeId);
            System.out.printf("####E1 %s %s%n", e5.getName(), e5.getSurname());


            session.getTransaction().commit();

        }


    }
}
