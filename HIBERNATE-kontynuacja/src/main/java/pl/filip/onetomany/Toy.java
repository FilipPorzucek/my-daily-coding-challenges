package pl.filip.onetomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Builder
@Getter
@Setter
@ToString(exclude = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="toy")
public class Toy {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "toy_id", unique = true,nullable = false)
        private Integer id;
        @Column(name = "what")
        private String what;
        @Column(name="color")
        private String color;


       /* @ManyToMany(mappedBy = "toys")
    private Set<Pet> pet;*/



    }




