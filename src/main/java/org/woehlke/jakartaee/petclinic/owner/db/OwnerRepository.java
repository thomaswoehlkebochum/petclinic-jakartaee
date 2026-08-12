package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.data.repository.*;
import org.woehlke.jakartaee.petclinic.owner.Owner;

import java.util.List;


@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {

    @Query("select s FROM Owner s where s.searchindex like :pattern order by s.lastName, s.firstName")
    List<Owner> findBySearchindexLike(@Param("pattern") String pattern);

}
