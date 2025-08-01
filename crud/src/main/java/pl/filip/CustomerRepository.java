package pl.filip;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaParameterExpression;


import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerRepository {
    Customer insertCustomer(final Customer customer){
        try (Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
            return customer;

        }catch (PersistenceException ex) {
            Throwable cause = ex.getCause();
            if (cause instanceof SQLException sqlEx) {
                System.err.println("SQLState: " + sqlEx.getSQLState());
                System.err.println("ErrorCode: " + sqlEx.getErrorCode());
                System.err.println("Message: " + sqlEx.getMessage());
            } else {
                System.err.println("Cause: " + cause);
            }
            return null;

        }
    }
    List<Customer> listCustomers(){
        try (Session session=HibernateUtil.getSession()){
            if (Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query="SELECT cust FROM Customer cust";
            List<Customer> customers=session.createQuery(query,Customer.class).list();
            session.getTransaction().commit();
            return customers;

        }

    }

    Optional<Customer> getCustomer(Integer customerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Customer.class, customerId));
        }
    }

    /*void updateCustomer(Integer customerId,Address newAddress){
        try (Session session=HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Customer customer=session.find(Customer.class,customerId);
            customer.setAddress(newAddress);
            session.getTransaction().commit();


        }
    }*/

    void deleteCustomer(Integer customerId){
        try (Session session=HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.remove(session.find(Customer.class,customerId));
            session.getTransaction().commit();
        }
    }

    void deleteAll(){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query="select cust from Customer cust";
            session.createQuery(query,Customer.class).list().forEach(session::remove);
            session.getTransaction().commit();
        }
    }

    void testSesssion(final int customerId){
        try (Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            Customer c1 = session.find(Customer.class, customerId);
            Customer c2 = session.find(Customer.class, customerId);

            System.out.println("c1==c2"+(c1==c2));
            System.out.println("c1,equalsc2"+(c1.equals(c2)));

            session.getTransaction().commit();
        }
    }


    public void criteriaExample() {
        try(Session session=HibernateUtil.getSession()){
            if (Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
            Root<Customer> root = query.from(Customer.class);

            query
                    .select(root)
                    .where(
                            criteriaBuilder.and(
                                    criteriaBuilder.like(root.get("email"),"%f%"),
                                    criteriaBuilder.isNotNull(root.get("phone"))
                            )
                    )
                    .orderBy(criteriaBuilder.desc(root.get("phone")));





            Query<Customer> query1 = session.createQuery(query);
            query1.setFirstResult(0);
            List<Customer> resultList = query1.getResultList();
            resultList.forEach(entity-> System.out.println("###Entity"+entity));



            session.getTransaction().commit();

        }
    }
}
