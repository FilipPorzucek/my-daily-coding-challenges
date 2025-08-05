package pl.filip.cache;



import java.time.OffsetDateTime;

public class ExampleData {
    static CachedEmployee someEmployee11(){
        return CachedEmployee.builder()
                .name("Agnieszka")
                .surname("Nowacka")
                .salary(3440)
                .since(OffsetDateTime.now())
                .build();
    }
    static CachedEmployee someEmployee22(){
        return CachedEmployee.builder()
                .name("Bartek")
                .surname("Kowalksi")
                .salary(4890)
                .since(OffsetDateTime.now())
                .build();
    }
    static CachedEmployee someEmployee33(){
        return CachedEmployee.builder()
                .name("Barbara")
                .surname("Mak")
                .salary(5462)
                .since(OffsetDateTime.now())
                .build();
    }
}
