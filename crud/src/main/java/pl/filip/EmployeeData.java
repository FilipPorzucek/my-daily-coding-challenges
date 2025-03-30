package pl.filip;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public class EmployeeData {
    static Employee someEmployee1() {
        return Employee.builder()
                .name("Jan")
                .surname("Kowalski")
                .salary(new BigDecimal("5000.00"))
                .since(OffsetDateTime.of(2020,1,1,10,10,10,0, ZoneOffset.UTC))
                .build();
    }
    static Employee someEmployee2() {
        return Employee.builder()
                .name("Stefan")
                .surname("Nowacki")
                .salary(new BigDecimal("3455.32"))
                .since(OffsetDateTime.of(2021,2,2,2,10,10,0, ZoneOffset.UTC))
                .build();
    }
    static Employee someEmployee3() {
        return Employee.builder()
                .name("Bartek")
                .surname("Kownacki")
                .salary(new BigDecimal("3112.00"))
                .since(OffsetDateTime.now())
                .build();
    }


}
