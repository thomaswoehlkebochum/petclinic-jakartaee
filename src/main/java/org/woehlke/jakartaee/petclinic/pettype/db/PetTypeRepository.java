package org.woehlke.jakartaee.petclinic.pettype.db;

import jakarta.data.repository.*;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import java.util.stream.Stream;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType,Long> {

    @Override
    @Find
    @OrderBy("name")
    Stream<PetType> findAll();
}
