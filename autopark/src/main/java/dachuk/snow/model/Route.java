package dachuk.snow.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "autobot" ,name = "route")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "driver_id")
    private int driverId;

    @Column(name = "status")
    private String status;


    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy = "route")
    private Transport transport;
}
