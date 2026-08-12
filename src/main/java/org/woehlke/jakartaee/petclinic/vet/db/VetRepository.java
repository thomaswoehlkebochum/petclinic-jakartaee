package org.woehlke.jakartaee.petclinic.vet.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import java.util.List;


@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {

    @Query("select o FROM Vet o where o.searchindex like :pattern")
    List<Vet> findBySearchindexLike(@Param("pattern") String pattern);

}
