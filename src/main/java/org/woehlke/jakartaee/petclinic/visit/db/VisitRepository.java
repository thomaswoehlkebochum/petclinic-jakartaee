package org.woehlke.jakartaee.petclinic.visit.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.visit.Visit;


@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
