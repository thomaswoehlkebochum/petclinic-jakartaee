package org.woehlke.jakartaee.petclinic.visit.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.util.List;


@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Find
    @OrderBy("date")
    List<Visit> findBy(Pet pet);
}
