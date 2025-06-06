package cl.ucm.serviceproduct.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int id;
    private String name;
    private int price;
    @Column(name = "id_category_fk")
    private int idCategoryFk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category_fk",
                referencedColumnName = "id_category",
                insertable = false,
                updatable = false
    )
    private Category category;

}
