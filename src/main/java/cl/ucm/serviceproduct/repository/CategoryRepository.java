package cl.ucm.serviceproduct.repository;

import cl.ucm.serviceproduct.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category where name=:name", nativeQuery = true)
    Category findByName(String name);

}
