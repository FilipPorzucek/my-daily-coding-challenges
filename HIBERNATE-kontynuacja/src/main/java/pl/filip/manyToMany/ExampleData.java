package pl.filip.manyToMany;

import java.time.OffsetDateTime;

public class ExampleData {

    static Employee someEmployee1(){
        return Employee.builder()
                .name("Agnieszka")
                .surname("Nowacka")
                .salary(3440)
                .since(OffsetDateTime.now())
                .build();
    }
    static Employee someEmployee2(){
        return Employee.builder()
                .name("Bartek")
                .surname("Kowalksi")
                .salary(4890)
                .since(OffsetDateTime.now())
                .build();
    }
    static Employee someEmployee3(){
        return Employee.builder()
                .name("Barbara")
                .surname("Mak")
                .salary(5462)
                .since(OffsetDateTime.now())
                .build();
    }

    static Project seomeProject1(){
        return Project.builder()
                .name("DataBase migration")
                .description("Lorem ipsum dolor simit amet")
                .deadline(OffsetDateTime.now())
                .build();
    }
    static Project seomeProject2 (){
        return Project.builder()
                .name("System migration")
                .description("Migration our system to diffrent environment")
                .deadline(OffsetDateTime.now())
                .build();
    }

}
