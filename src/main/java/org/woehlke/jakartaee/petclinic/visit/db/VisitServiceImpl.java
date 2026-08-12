package org.woehlke.jakartaee.petclinic.visit.db;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


/**
 *
 */
@Log
@ApplicationScoped
@Transactional
public class VisitServiceImpl implements VisitService, Serializable {

    private static final long serialVersionUID = 4560958540651968289L;

    @EJB
    private VisitDao visitDao;

    @Inject
    private VisitRepository visitRepository;

    @Override
    public List<Visit> getAll() {
        return this.visitRepository.findAll().toList();
    }

    @Override
    public Optional<Visit> findById(long id) {
        return this.visitRepository.findById(id);
    }

    @Override
    public Visit addNew(Visit visit) {
        visit.updateSearchindex();
        log.info("addNew Visit: " + visit.toString());
        return this.visitRepository.insert(visit);
    }

    @Override
    public Visit update(Visit visit) {
        visit.updateSearchindex();
        log.info("update Visit: " + visit.toString());
        return this.visitRepository.update(visit);
    }

    @Override
    public void delete(long id) {
        log.info("delete: " + id);
        this.visitRepository.deleteById(id);
    }

    @Override
    public List<Visit> getAllVisitsOfAnPet(Pet pet) {
        //TODO
        return this.visitDao.getVisits(pet);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+VisitServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+VisitServiceImpl.class.getSimpleName());
    }


}
