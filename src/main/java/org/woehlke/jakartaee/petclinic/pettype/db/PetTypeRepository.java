package org.woehlke.jakartaee.petclinic.pettype.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
