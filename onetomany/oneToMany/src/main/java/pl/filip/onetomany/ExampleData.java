package pl.filip.onetomany;

public  class ExampleData {
    static Owner someOwner(){
        return Owner.builder()
                .name("Stefan")
                .surname("Nowacki")
                .phone("234 234 234")
                .email("stefa@sdf.pl")
                .build();
    }

    static Owner someOwner2(){
        return Owner.builder()
                .name("Adrian")
                .surname("Kell")
                .phone("654 654 644")
                .email("add@op.pl")
                .build();
    }

    static Pet somePet1(){
        return Pet.builder().name("Fafik").breed(Breed.DOG).build();
    }
    static Pet somePet2(){
        return Pet.builder().name("Czarus").breed(Breed.CAT).build();
    }
    static Pet somePet3(){
        return Pet.builder().name("Alanek").breed(Breed.MONKEY).build();
    }
    static Pet somePet4(){
        return Pet.builder().name("Lapka").breed(Breed.CAT).build();
    }
}
