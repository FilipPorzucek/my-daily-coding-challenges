package pl.filip.onetomany;

import pl.filip.HibernateUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static pl.filip.onetomany.ExampleData.*;

public class OneToManyRunner {
    public static void main(String[] args) {
        OwnerRepository ownerRepository=new OwnerRepository();
        ownerRepository.deleteAll();
        Owner owner = ownerRepository.insertData(someOwner(), Set.of(somePet1(), somePet2()));
        Owner owner1 = ownerRepository.insertData(someOwner2(), Set.of(somePet3(), somePet4()));

        ownerRepository.nativeQueryExample();






        HibernateUtil.closeSessionFactory();

//
//        ownerRepository.deleteAll();
//
//     ownerRepository.selectExample5().forEach(entity-> System.out.println(entity));


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
