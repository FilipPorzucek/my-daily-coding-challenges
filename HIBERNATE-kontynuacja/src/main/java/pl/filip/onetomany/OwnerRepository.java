package pl.filip.onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import pl.filip.HibernateUtil;

import java.util.*;

public class OwnerRepository {

    Owner insertData(final Owner owner, final Set<Pet> pets) {

        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
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

    List<Owner> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
            List<Owner> owners = session.createQuery(query, Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    Optional<Owner> getOwner(Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE GET OWNER\n-------------------");
            Owner owner = session.find(Owner.class, ownerId);
            System.out.println("###AFTER GET Owner\n-------------------");
            System.out.println(owner);
            return Optional.of(owner);
        }
    }

    void updateOwner(Integer ownerId, Pet newPet) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Owner owner = session.find(Owner.class, ownerId);
            owner.getPets().add(newPet);
            session.getTransaction().commit();
        }
    }

    void deleteOwner(Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE DELETE \n-------------------");
            session.beginTransaction();
            session.remove(session.find(Owner.class, ownerId));
            session.getTransaction().commit();
            System.out.println("###AFTER DELETE \n-------------------");
        }
    }

    void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE DELETE ALL\n-------------------");
            session.beginTransaction();
            String query = "select owner from Owner owner";
            session.createQuery(query, Owner.class).list().forEach(session::remove);
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

            Owner owner = session.find(Owner.class, ownerId);
            Pet petToRemove = owner.getPets().stream().findAny().orElseThrow();
            owner.removePet(petToRemove);
            session.merge(owner);
            session.getTransaction().commit();
            System.out.println("###After Orphan");
        }
    }

    int insertHQL() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityMenager is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();
            String hql = """
                    INSERT Owner (name, surname,phone,email)
                    VALUES ('Romek','Zabawniacha','+48 123 123 123','romwk@saas.pl')
                    """;
            Query query = entityManager.createQuery(hql);
            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }

        return result;
    }

    int updateHQL(final String oldEmail, final String newPhone, final String newEmail) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityMenager is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();


            String hql = """
                    Update Owner ow
                    SET ow.phone= :newPhone,ow.email= :newEmail
                    WHERE ow.email=:oldEmail
                    """;
            Query query = entityManager.createQuery(hql)
                    .setParameter("oldEmail", oldEmail)
                    .setParameter("newPhone", newPhone)
                    .setParameter("newEmail", newEmail);


            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }

        return result;
    }

    int deleteHQL(final String email) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityMenager is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();


            String hql = """
                    DELETE FROM Owner ow
                    WHERE ow.email=:email
                    """;
            Query query = entityManager.createQuery(hql)
                    .setParameter("email", email);


            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }

        return result;
    }

    List<Owner> selectExample1() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
            List<Owner> owners = session.createQuery(query, Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<ToyStat> selectExample2() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String query = "SELECT new pl.filip.onetomany.OwnerTemp(ow.id,ow.name)FROM Owner ow";
            List<ToyStat> owners = session.createQuery(query, ToyStat.class).getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample3() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Sessino is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner ow WHERE ow.email=:email";
            List<Owner> owners = session.
                    createQuery(query, Owner.class)
                    .setParameter("email", "stefa@sdf.pl")
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample4() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner ow ORDER BY ow.email ASC,ow.name DESC";
            List<Owner> owners = session.
                    createQuery(query, Owner.class)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectExample5() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner ow ORDER BY ow.email DESC";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .setFirstResult(0)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    Optional<Owner> selectExample6(final String name) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String select6 = "SELECT ow FROM Owner ow WHERE ow.name =:name ";
            Optional<Owner> name1 = session.createQuery(select6, Owner.class)
                    .setParameter("name", name)
                    .uniqueResultOptional();
            session.getTransaction().commit();
            return name1;
        }
    }

    void selectExample7() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String select7 = "SELECT ow FROM Owner ow FULL JOIN  ow.pets pt ";
            session.createQuery(select7, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###ENTITY" + entity));


            session.getTransaction().commit();

        }
    }

 /*   int saveTestData(){
        try (Session session=HibernateUtil.getSession()){
            if(Objects.isNull(session)){
                throw new RuntimeException("Session is null");
            }

            session.beginTransaction();
            Toy toy1=ExampleData.someToy1();
            Toy toy2=ExampleData.someToy2();
            Toy toy3=ExampleData.someToy3();
            Toy toy4=ExampleData.someToy4();
            session.persist(toy1);
            session.persist(toy2);
            session.persist(toy3);
            session.persist(toy4);

            Pet pet1 = ExampleData.somePet1();
            Pet pet2 = ExampleData.somePet2();
            Pet pet3 = ExampleData.somePet3();
            Pet pet4 = ExampleData.somePet4();

            pet1.setToys(List.of(toy1,toy2));
            pet2.setToys(List.of(toy2,toy3));
            pet3.setToys(List.of(toy1,toy2,toy3));
            pet4.setToys(List.of(toy2,toy3,toy4));

            Owner owner1=ExampleData.someOwner();
            Owner owner2=ExampleData.someOwner2();
            owner1.setPets(List.of());
            owner2.setPets(List.of(pet3,pet4));

            owner1.getPets().forEach(pet-> pet.setOwner(owner1));
            owner2.getPets().forEach(pet -> pet.setOwner(owner2));

            session.persist(owner1);
            session.persist(owner2);
            session.getTransaction().commit();

        return owner1.getId();
        }
    }
*/
    void selectExample8() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String select8 = "SELECT ow FROM Owner ow " +
                    "INNER JOIN FETCH ow.pets pt " +
                    "INNER JOIN FETCH pt.toys ts";
            session.createQuery(select8, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###ENTITY" + entity));


            session.getTransaction().commit();

        }
    }

    void selectExample9() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String select9 = "SELECT new pl.filip.onetomany.ToyStat(" +
                    "MAX(t.what),SUM(t.id)/COUNT (t.id))FROM Toy t";
            session.createQuery(select9, ToyStat.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###ENTITY" + entity));


            session.getTransaction().commit();

        }
    }

    void selectExampleN1() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String hql = "SELECT ow FROM Owner ow ";
            session.createQuery(hql, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println(entity));
            session.getTransaction().commit();
        }
    }

/*    void setVsListExample(final Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            System.out.println("###BEFORE SET VS LIST");
            List<Pet> pets=session.find(Owner.class,id).getPets();
            pets.forEach(pet -> pet.getToys().remove(pet.getToys().stream().findAny().get()));
            System.out.println("###AFTER SET VS LIST");
            session.getTransaction().commit();
        }
    }*/


   void nativeQueryExample() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String sql="SELECT * FROM Owner";
            NativeQuery<Owner> nativeQuery = session.getNamedNativeQuery("Owner.findAllNative");
            List<Owner> owner = nativeQuery.list();
            owner.forEach(owner1 -> System.out.println(owner1));
            session.getTransaction().commit();
        }
    }


}


