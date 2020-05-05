package dachuk.snow.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(schema = "autobot" ,name = "transport")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Transport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "model")
    private String model;


    @Column(name = "state")
    private String state;

    @Column(name = "type")
    private String type;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

}
