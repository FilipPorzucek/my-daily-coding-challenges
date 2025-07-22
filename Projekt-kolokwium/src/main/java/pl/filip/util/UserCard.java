package pl.filip.util;


import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_card")
public class UserCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",unique=true,nullable = false)
    private Long id;

    @Column(name="first_name")
    private String name;

    @Column(name="second_name")
    private String secondName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="note")
    private String note;


}
