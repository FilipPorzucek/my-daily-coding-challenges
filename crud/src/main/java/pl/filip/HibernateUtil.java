package pl.filip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;
import java.util.Map;
import java.util.Objects;

public class HibernateUtil {
    private static final Map<String, Object> SETTINGS=Map.ofEntries(
            Map.entry(Environment.DRIVER,"org.postgresql.Driver"),
        Map.entry(Environment.URL, "jdbc:postgresql://localhost:5432/crud"),
        Map.entry(Environment.USER,"postgres"),
        Map.entry(Environment.PASS,"brasil9"),
        Map.entry(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect"),
        Map.entry(Environment.HBM2DDL_AUTO,"update"),
        Map.entry(Environment.SHOW_SQL,"true"),
        Map.entry(Environment.FORMAT_SQL ,"true")
    );

    private static SessionFactory sessionFactory=loadSessionFactory();

    private static SessionFactory loadSessionFactory() {
        try{
            ServiceRegistry serviceRegistry= (ServiceRegistry) new StandardServiceRegistryBuilder()
                    .applySettings(SETTINGS)
                    .build();

            Metadata metadata=new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Address.class)
                    .getMetadataBuilder()
                    .build();
            return metadata.getSessionFactoryBuilder().build();
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }

    }

    static void closeSessionFactory(){
        try {
            sessionFactory.close();
        }catch (Exception e){
            System.err.println("Exception while closing factory"+e);
        }
    }

    static Session getSession(){
        try {
            return sessionFactory.openSession();
        }catch (Exception e){
            System.err.println("Exception while opening session"+e);
        }
        return null;
    }
}
