package pl.filip.onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import org.hibernate.Session;
import pl.filip.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OwnerRepository {

    Owner insertData(final Owner owner, final Set<Pet> pets){

        try(Session session= HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORET INSERT\n---------------------------------------------------");
            session.beginTransaction();
            owner.setPets(pets);
            pets.forEach(pet -> pet.setOwner(owner));
            session.persist(owner);
            pets.forEach(session::persist);

            session.getTransaction().commit();
            System.out.println("###AFTER INSERT\n---------------------------------------------------");
            return owner;
        }
    }

    List<Owner> findAll(){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String query="FROM Owner";
            List<Owner> owners=session.createQuery(query,Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    Optional<Owner> getOwner(Integer ownerId){
        try(Session session=HibernateUtil.getSession()) {
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE GET OWNER\n-------------------");
           Owner owner=session.find(Owner.class,ownerId);
            System.out.println("###AFTER GET OWNER\n-------------------");
            System.out.println("###BEFORE GET PETS\n-------------------");
            System.out.println(owner.getPets());
            System.out.println("###AFTER GET PETS\n-------------------");
           return Optional.of(owner);
        }
    }

    void updateOwner(Integer ownerId,Pet newPet){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Owner owner=session.find(Owner.class,ownerId);
            owner.getPets().add(newPet);
            session.getTransaction().commit();
        }
    }

    void deleteOwner(Integer ownerId){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE DELETE \n-------------------");
            session.beginTransaction();
            session.remove(session.find(Owner.class,ownerId));
            session.getTransaction().commit();
            System.out.println("###AFTER DELETE \n-------------------");
        }
    }

    void deleteAll(){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE DELETE ALL\n-------------------");
            session.beginTransaction();
           String query="select owner from Owner owner";
            session.createQuery(query,Owner.class).list().forEach(session::remove);
            session.getTransaction().commit();
            System.out.println("###AFTER DELETE ALL\n-------------------");
        }
    }

    void orchallRemovalExample(final Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###Before Orphan");
            session.beginTransaction();

             Owner owner=session.find(Owner.class,ownerId);
            Pet petToRemove=owner.getPets().stream().findAny().orElseThrow();
            owner.removePet(petToRemove);
            session.merge(owner);
            session.getTransaction().commit();
            System.out.println("###After Orphan");
        }
    }

    int insertHQL(){
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        int result;
        try{
            entityManager=HibernateUtil.getSession();
            if(Objects.isNull(entityManager)){
                throw new RuntimeException("EntityMenager is null");
            }
            transaction=entityManager.getTransaction();
            transaction.begin();
            String hql= """
                    INSERT Owner (name, surname,phone,email)
                    VALUES ('Romek','Zabawniacha','+48 123 123 123','romwk@saas.pl')
                    """;
            Query query=entityManager.createQuery(hql);
            result=query.executeUpdate();
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            if(Objects.nonNull(transaction)&& transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }finally {
            if(Objects.nonNull(entityManager)){
                entityManager.close();
            }
        }

return result;
    }

    int updateHQL(final String oldEmail,final String newPhone,final String newEmail){
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        int result;
        try{
            entityManager=HibernateUtil.getSession();
            if(Objects.isNull(entityManager)){
                throw new RuntimeException("EntityMenager is null");
            }
            transaction=entityManager.getTransaction();
            transaction.begin();


            String hql= """
                    Update Owner ow
                    SET ow.phone= :newPhone,ow.email= :newEmail
                    WHERE ow.email=:oldEmail
                    """;
            Query query=entityManager.createQuery(hql)
                    .setParameter("oldEmail",oldEmail)
                    .setParameter("newPhone",newPhone)
                    .setParameter("newEmail",newEmail);


            result=query.executeUpdate();
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            if(Objects.nonNull(transaction)&& transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }finally {
            if(Objects.nonNull(entityManager)){
                entityManager.close();
            }
        }

        return result;
    }

    int deleteHQL(final String email){
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        int result;
        try{
            entityManager=HibernateUtil.getSession();
            if(Objects.isNull(entityManager)){
                throw new RuntimeException("EntityMenager is null");
            }
            transaction=entityManager.getTransaction();
            transaction.begin();


            String hql= """
                    DELETE FROM Owner ow
                    WHERE ow.email=:email
                    """;
            Query query=entityManager.createQuery(hql)
                    .setParameter("email",email);



            result=query.executeUpdate();
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            if(Objects.nonNull(transaction)&& transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }finally {
            if(Objects.nonNull(entityManager)){
                entityManager.close();
            }
        }

        return result;
    }

    List<Owner> selectExample1(){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String query="FROM Owner";
            List<Owner> owners=session.createQuery(query,Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample2(){
        try(Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String selectExample2="SELECT ow FROM Owner ow";
           List<Owner> owners= session.createQuery(selectExample2, Owner.class)
                           .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    }


