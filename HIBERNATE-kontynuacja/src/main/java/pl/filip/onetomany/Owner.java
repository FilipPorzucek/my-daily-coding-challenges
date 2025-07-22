package pl.filip.onetomany;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="owner")

public class Owner  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", unique = true,nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets;

    public void removePet(final Pet pet){
       pets.remove(pet);
    }

}
