package org.woehlke.jakartaee.petclinic.visit.db;

import org.woehlke.jakartaee.petclinic.application.framework.db.CrudService;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 */
public interface VisitService extends CrudService<Visit>, Serializable {

    @Serial
    long serialVersionUID = -207047254562666324L;

}
