package pl.filip.locks;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(of="eventId")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private Long eventId;

    @Column(name = "eventName")
    private String name;

    @Column(name = "dateTime")
    private OffsetDateTime dateTime;

    private Integer capacity;

    @OneToMany(mappedBy = "event")
    private Set<TicketEntity> tickets;

    @Version
    private Long version;

    public void addTicket(TicketEntity ticket) {
        ticket.setEvent(this);
        getTickets().add(ticket);
    }



}
