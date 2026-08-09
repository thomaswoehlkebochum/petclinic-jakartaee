package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.data.repository.*;
import org.woehlke.jakartaee.petclinic.owner.Owner;


@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {

}
