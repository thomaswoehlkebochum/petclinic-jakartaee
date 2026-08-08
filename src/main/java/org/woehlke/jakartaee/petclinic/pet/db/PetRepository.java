package org.woehlke.jakartaee.petclinic.pet.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.pet.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
