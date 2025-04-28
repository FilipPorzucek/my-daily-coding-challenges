package pl.filip;

public class ExampleData {

    static Address AddresssomeAddress1(){
        return Address.builder()
                .country("Poland")
                .city("Szczecin")
                .postalCode("70-112")
                .address("Witolda Starkiewicza 3")
                .build();
    }
    static Address AddresssomeAddress2(){
        return Address.builder()
                .country("Poland")
                .city("Gdynia")
                .postalCode("81-357")
                .address("3 maja 16+")
                .build();
    }

    static Customer someCustomer1(){
        return Customer.builder().
                name("Stefan")
                .surname("Nowacki")
                .phone("+48 589 344 234")
                .email("stefan@sdf.pl")
                .address(AddresssomeAddress1())
                .build();
    }

    static Customer someCustomer2(){
        return Customer.builder()
                .name("Adrian")
                .surname("Paczkomat")
                .phone("+48 234 243 567")
                .email("sdfsf@ss3.pl")
                .address(AddresssomeAddress1())
                 .build();
    }


}
