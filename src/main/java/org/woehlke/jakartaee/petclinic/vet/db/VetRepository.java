package org.woehlke.jakartaee.petclinic.vet.db;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.woehlke.jakartaee.petclinic.vet.Vet;

@Repository
public interface VetRepository extends CrudRepository<Vet,Long> {
}
