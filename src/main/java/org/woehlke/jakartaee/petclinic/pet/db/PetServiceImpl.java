package org.woehlke.jakartaee.petclinic.pet.db;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.woehlke.jakartaee.petclinic.visit.Visit;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


/**
 *
 */
@Log
@Named("petService")
@ApplicationScoped
@Transactional
public class PetServiceImpl implements PetService, Serializable  {

    private static final long serialVersionUID = -2093524918552358722L;

    @EJB
    private PetDao petDao;

    @Inject
    private PetRepository petRepository;

    @Override
    public Pet addNew(Pet pet) {
        pet.updateSearchindex();
        log.info("addNew Pet: " + pet.toString());
        return this.petRepository.insert(pet);
    }

    @Override
    public List<Pet> getAll() {
        return this.petDao.getAll();
    }

    @Override
    public Optional<Pet> findById(long petId) {
        return this.petRepository.findById(petId);
    }

    @Override
    public Pet update(Pet pet) {
        pet.updateSearchindex();
        log.info("update Pet: " + pet.toString());
        return this.petRepository.update(pet);
    }

    @Override
    public void delete(long id) {
        log.info("delete Pet: " + id);
        this.petRepository.deleteById(id);
    }


    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+PetServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+PetServiceImpl.class.getSimpleName());
    }

    @Override
    public List<Visit> getVisits(Pet pet) {
        return this.petDao.getVisits(pet);
    }
}
