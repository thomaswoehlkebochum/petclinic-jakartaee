package org.woehlke.jakartaee.petclinic.pet.db;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.visit.db.VisitRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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

    @Inject
    private PetRepository petRepository;

    @Inject
    private VisitRepository visitRepository;

    @Override
    public Pet addNew(Pet pet) {
        pet.updateSearchindex();
        log.info("addNew Pet: " + pet.toString());
        return this.petRepository.insert(pet);
    }

    @Override
    public List<Pet> getAll() {
        List<Pet> all = new ArrayList<>(this.petRepository.findAll().toList());
        Collections.sort(all);
        return all;
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
        return visitRepository.findByPet(pet);
    }
}
