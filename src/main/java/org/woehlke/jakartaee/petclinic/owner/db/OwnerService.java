package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.validation.constraints.NotNull;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.application.framework.db.CrudService;
import org.woehlke.jakartaee.petclinic.application.framework.db.SearchableService;

import java.io.Serial;
import java.util.List;

/**
 * Created by tw on 10.03.14.
 */
public interface OwnerService extends CrudService<Owner>, SearchableService<Owner> {

    @Serial
    long serialVersionUID = -5744255576144969978L;

    List<Pet> getPetsAsList(@NotNull Owner owner);
}
