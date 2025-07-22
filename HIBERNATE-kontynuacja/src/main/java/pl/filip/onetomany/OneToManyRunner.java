package pl.filip.onetomany;

import pl.filip.HibernateUtil;

import java.util.Set;

public class OneToManyRunner {
    public static void main(String[] args) {
        OwnerRepository ownerRepository=new OwnerRepository();
        PetRepository petRepository=new PetRepository();
        ownerRepository.selectExampleN1();



//
//        ownerRepository.deleteAll();
//
//     ownerRepository.selectExample5().forEach(entity-> System.out.println(entity));

        HibernateUtil.closeSessionFactory();
//
//        ownerRepository.listOwners()
//                .forEach(owner -> System.out.println("###ONWER listing "+owner));

//        System.out.println("###Owner1" + ownerRepository.getOwner(owner1.getId()));
//        System.out.println("###Owner2"+ownerRepository.getOwner(owner2.getId()));
//
 //      Pet newPet=Pet.builder().name("Drapek").breed(Breed.MONKEY).owner(owner1).build();
  //      ownerRepository.updateOwner(owner1.getId(),newPet);

//        ownerRepository.orchallRemovalExample(owner1.getId());

//        System.out.println("Owner upgrated "+ownerRepository.getOwner(owner1.getId()));
//        ownerRepository.listOwners();
//


    }
}
