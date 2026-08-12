package org.woehlke.jakartaee.petclinic.pet.db;

import jakarta.data.repository.*;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    @Find
    @OrderBy("name")
    List<Pet> findByOwner(@By("owner") Owner owner);
}
