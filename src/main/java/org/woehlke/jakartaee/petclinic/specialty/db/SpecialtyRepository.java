package org.woehlke.jakartaee.petclinic.specialty.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
