package dachuk.snow.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(schema = "autobot" ,name = "user")
@EntityListeners(AuditingEntityListener.class)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @Column(name = "mobile")
    private String mobile;



    @OneToOne(mappedBy = "user")
    private Route route;
}
