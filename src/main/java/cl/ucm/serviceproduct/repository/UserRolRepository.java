package cl.ucm.serviceproduct.repository;

import cl.ucm.serviceproduct.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {

    /*
        select r.name from rol r
        inner join user_rol ur on ur.rol_fk=r.id_rol
        inner join user u on ur.user_fk=u.email
        where u.email=:username


     */


    @Query(value = "select r.name from rol r inner join user_rol ur on ur.rol_fk=r.id_rol inner join user u on ur.user_fk=u.email  where u.email=:username", nativeQuery = true)
    List<String> getRolesByUsername(String username);

}
