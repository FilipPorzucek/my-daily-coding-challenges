package pl.filip;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@ToString(exclude = "address")
@EqualsAndHashCode(of="email")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",unique = true,nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",unique = true)
    private Address address;

}
