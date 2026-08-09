package org.woehlke.jakartaee.petclinic.specialty.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.specialty.Specialty;

import java.util.stream.Stream;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {

    @Override
    @Find
    @OrderBy("name")
    Stream<Specialty> findAll();
}
