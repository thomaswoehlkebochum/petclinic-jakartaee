package org.woehlke.jakartaee.petclinic.pet.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    @Find
    @OrderBy("name")
    List<Pet> findBy(Owner owner);
}
