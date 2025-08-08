package pl.filip.locks;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(of="ticketId")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")

public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticketId")
    private Long ticketId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="eventId")
    private EventEntity event;



}
