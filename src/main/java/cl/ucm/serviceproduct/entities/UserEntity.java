package cl.ucm.serviceproduct.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    private String email;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String password;
}
