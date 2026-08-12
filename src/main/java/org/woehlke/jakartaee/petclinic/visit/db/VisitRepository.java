package org.woehlke.jakartaee.petclinic.visit.db;

import jakarta.data.repository.*;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.util.List;


@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Find
    @OrderBy("date")
    List<Visit> findByPet(@By("pet") Pet pet);
}
