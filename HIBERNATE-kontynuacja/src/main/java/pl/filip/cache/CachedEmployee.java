package pl.filip.cache;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(of="employee_id")
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name="cached_employee")
public class CachedEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Integer employee_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private Integer salary;

    @Column(name="since")
    private OffsetDateTime since;


}
