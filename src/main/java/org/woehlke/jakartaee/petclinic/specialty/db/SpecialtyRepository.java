package org.woehlke.jakartaee.petclinic.specialty.db;

import jakarta.data.repository.*;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.util.List;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {

    @Query("select s FROM Specialty s where s.searchindex like :pattern order by s.name")
    List<Specialty> findBySearchindexLike(@Param("pattern") String pattern);

    //TODO remove? see View
    @Find
    @OrderBy("name")
    Specialty findSpecialtyByName(String name);
}
