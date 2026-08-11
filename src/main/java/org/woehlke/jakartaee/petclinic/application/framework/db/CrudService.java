package org.woehlke.jakartaee.petclinic.application.framework.db;

import jakarta.transaction.Transactional;
import org.woehlke.jakartaee.petclinic.application.framework.EntityBase;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @param <T>
 */
@Transactional
public interface CrudService<T extends EntityBase> extends Serializable {

    long serialVersionUID = 8240918516324226703L;

    List<T> getAll();

    Optional<T> findById(long id);

    T addNew(T entity);

    T update(T entity);

    @Transactional(value= Transactional.TxType.REQUIRES_NEW)
    void delete(long id);

}
