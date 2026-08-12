package org.woehlke.jakartaee.petclinic.application.framework.db;

import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;

import java.util.List;

/**
 * @param <T>
 */
public interface SearchableService<T extends EntityBase> {

    long serialVersionUID = -1893303126489909752L;

    List<T> search(String searchterm);

}
