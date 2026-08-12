package org.woehlke.jakartaee.petclinic.pettype.db;

import jakarta.data.repository.*;
import jakarta.transaction.Transactional;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.util.List;
import java.util.stream.Stream;

@Repository
@Transactional
public interface PetTypeRepository extends CrudRepository<PetType,Long> {

    @Override
    @Find
    @OrderBy("name")
    Stream<PetType> findAll();

    @Query("select s FROM PetType s where s.searchindex like :pattern order by s.name")
    List<PetType> findBySearchindexLike(@Param("pattern") String pattern);

}
