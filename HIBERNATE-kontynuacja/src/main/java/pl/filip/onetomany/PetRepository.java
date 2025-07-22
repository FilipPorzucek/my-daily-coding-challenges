package pl.filip.onetomany;

import org.hibernate.Session;
import pl.filip.HibernateUtil;

import java.util.Objects;
import java.util.Set;

public class PetRepository {
    Pet insertPet( Pet pet){

        try(Session session= HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORET INSERT\n---------------------------------------------------");
            session.beginTransaction();
           session.persist(pet);

            session.getTransaction().commit();
            System.out.println("###AFTER INSERT\n---------------------------------------------------");
            return pet;
        }
    }
}
