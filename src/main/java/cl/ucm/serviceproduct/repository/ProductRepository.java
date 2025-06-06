package cl.ucm.serviceproduct.repository;

import cl.ucm.serviceproduct.dto.out.ProductDtoOut;
import cl.ucm.serviceproduct.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    @Query(value = "select p.id_product id, p.name, p.price, c.name category from product p inner join category c on c.id_category=p.id_category_fk", nativeQuery = true)
    List<ProductDtoOut> findProducts();

}
