package pl.filip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;
import pl.filip.manyToMany.Employee;
import pl.filip.manyToMany.Project;
import pl.filip.onetomany.Owner;
import pl.filip.onetomany.Pet;
import pl.filip.onetomany.Toy;

import java.util.Map;
import java.util.Objects;

public class HibernateUtil {
    private static final Map<String, Object> SETTINGS=Map.ofEntries(
            Map.entry(Environment.DRIVER,"org.postgresql.Driver"),
            Map.entry(Environment.URL, "jdbc:postgresql://localhost:5432/pet"),
            Map.entry(Environment.USER,"postgres"),
            Map.entry(Environment.PASS,"1234"),
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
                    .addAnnotatedClass(Pet.class)
                    .addAnnotatedClass(Owner.class)
                    .addAnnotatedClass(Toy.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Project.class)
                    .getMetadataBuilder()
                    .build();
            return metadata.getSessionFactoryBuilder().build();
        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }

    }

    public static void closeSessionFactory(){
        try {
            sessionFactory.close();
        }catch (Exception e){
            System.err.println("Exception while closing factory"+e);
        }
    }

    public static Session getSession(){
        try {
            return sessionFactory.openSession();
        }catch (Exception e){
            System.err.println("Exception while opening session"+e);
        }
        return null;
    }
}
