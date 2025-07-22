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
    static Owner someOwner3(){
        return Owner.builder()
                .name("Filip")
                .surname("Porz")
                .phone("123 123 123")
                .email("fil@op.pl")
                .build();
    }

    static Owner someOwner4(){
        return Owner.builder()
                .name("Monika")
                .surname("Lelowksa")
                .phone("654 654 644")
                .email("mon@op.pl")
                .build();
    }

    static Owner someOwner5(){
        return Owner.builder()
                .name("Marek")
                .surname("Zamek")
                .phone("435 543 545")
                .email("mar@op.pl")
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

    public static Toy someToy1() {
        return Toy.builder()
                .what("car")
                .color("white")
                .build();

    }
    public static Toy someToy2() {
        return Toy.builder()
                .what("cat")
                .color("green")
                .build();


    }

    public static Toy someToy3() {
        return Toy.builder()
                .what("bear")
                .color("yellow")
                .build();
    }


        public static Toy someToy4() {
            return Toy.builder()
                    .what("duck")
                    .color("blue")
                    .build();
        }
}
