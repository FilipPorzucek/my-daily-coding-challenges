package pl.filip.onetomany;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "email")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="owner")

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Owner.findAllNative",
                        query = "SELECT * FROM Owner",
                        resultClass = Owner.class
                )
        }
)

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
    @OrderBy("breed ASC")
    private Set<Pet> pets;

    public void removePet(final Pet pet){
       pets.remove(pet);
    }

}
