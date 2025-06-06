package cl.ucm.serviceproduct.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_user")
    private int id;
    @Column(name = "rol_fk")
    private int rolFK;
    @Column(name = "user_fk")
    private String userFK;

    //relacion a nivel de sql y java
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_fk", referencedColumnName = "id_rol", insertable = false, updatable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk", referencedColumnName = "email", insertable = false, updatable = false)
    private UserEntity user;



}
