package org.woehlke.jakartaee.petclinic.vet.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import java.util.stream.Stream;

@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {

    @Override
    @Find
    @OrderBy("lastName")
    @OrderBy("firstName")
    Stream<Vet> findAll();
}
