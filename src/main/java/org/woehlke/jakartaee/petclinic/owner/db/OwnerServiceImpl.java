package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.db.PetDao;
import org.woehlke.jakartaee.petclinic.pet.db.PetRepository;
import org.woehlke.jakartaee.petclinic.visit.db.VisitDao;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.woehlke.jakartaee.petclinic.visit.db.VisitRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tw on 10.03.14.
 */
@Log
@Named("ownerService")
@ApplicationScoped
public class OwnerServiceImpl implements OwnerService, Serializable {

    private static final long serialVersionUID = -553095693269912269L;

    @EJB
    private OwnerDao ownerDao;

    @EJB
    private PetDao petDao;

    @EJB
    private VisitDao visitDao;

    @Inject
    private OwnerRepository ownerRepository;

    @Inject
    private PetRepository petRepository;

    @Inject
    private VisitRepository visitRepository;

    @Override
    public Visit addNewVisit(Visit visit) {
        log.info("addNew Visit: " + visit.toString());
        Pet pet = visit.getPet();
        Owner owner = pet.getOwner();
        visit.setPet(null);
        visit = visitRepository.insert(visit);
        owner = ownerRepository.update(owner);
        pet.setOwner(owner);
        pet = petRepository.update(pet);
        visit.setPet(pet);
        visit = visitRepository.update(visit);
        log.info("added new Visit - updated owner: " + owner.toString());
        log.info("added new Visit - updated pet:   " + pet.toString());
        log.info("added new Visit:                 " + visit.toString());
        return visit;
    }

    @Override
    public List<Pet> getPetsAsList(@NotNull Owner owner){
        return petDao.getPetsAsList(owner);
    }

    @Override
    public String getPetsAsString(@NotNull Owner owner) {
        StringBuilder s = new StringBuilder();
        for (Pet pet : this.getPetsAsList(owner)) {
            s.append(pet.getName())
                    .append(" (")
                    .append(pet.getType().getName())
                    .append(") ");
        }
        return s.toString();
    }

    @Override
    public void resetSearchIndex() {
        for(Owner owner: this.getAll()){
            for (Pet pet : this.getPetsAsList(owner)) {
                for(Visit visit:visitDao.getVisits(pet)){
                    this.visitRepository.update(visit);
                }
                this.petRepository.update(pet);
            }
            this.ownerRepository.update(owner);
        }
    }

    @Override
    public List<Owner> getAll() {
        return this.ownerDao.getAll();
    }

    @Override
    public void delete(long id) {
        this.ownerRepository.deleteById(id);
    }

    @Override
    public Owner addNew(Owner owner) {
        //owner = this.updateSearchindex(owner); TODO
        log.info("addNew Owner: " + owner.toString());
        return this.ownerRepository.insert(owner);
    }

    @Override
    public Owner findById(long id) {
        return this.ownerDao.findById(id);
    }

    @Override
    public Owner update(Owner owner) {
        //owner = this.updateSearchindex(owner); TODO
        log.info("update Owner: " + owner.toString());
        return this.ownerRepository.update(owner);
    }

    private Owner updateSearchindex(Owner owner) {
        //TODO
        for(Pet pet:this.petDao.getPetsAsList(owner)){
            for(Visit visit:visitDao.getVisits(pet)){
                this.visitRepository.update(visit);
            }
            this.petRepository.update(pet);
        }
        return owner;
    }

    @Override
    public List<Owner> search(String searchterm) {
        return this.ownerDao.search(searchterm);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+OwnerServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+OwnerServiceImpl.class.getSimpleName());
    }
}
