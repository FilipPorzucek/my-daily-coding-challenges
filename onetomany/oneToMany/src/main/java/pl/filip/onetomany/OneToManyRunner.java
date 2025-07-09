package pl.filip.onetomany;

import pl.filip.HibernateUtil;

import java.util.Set;

public class OneToManyRunner {
    public static void main(String[] args) {
        OwnerRepository ownerRepository=new OwnerRepository();
        ownerRepository.selectExample2().forEach(owner -> System.out.println(owner));
//
//        ownerRepository.deleteAll();
//
//        Owner owner1=ownerRepository.insertData(
//                ExampleData.someOwner(),
 //               Set.of(ExampleData.somePet1(),ExampleData.somePet2()));
//        Owner owner2=ownerRepository.insertData(
//                ExampleData.someOwner2(),
//                Set.of(ExampleData.somePet3(),ExampleData.somePet4())
//        );
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
//        HibernateUtil.closeSessionFactory();

    }
}
