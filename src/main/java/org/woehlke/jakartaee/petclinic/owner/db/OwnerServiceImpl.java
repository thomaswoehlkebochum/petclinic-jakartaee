package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.woehlke.jakartaee.petclinic.pet.db.PetRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by tw on 10.03.14.
 */
@Log
@Named("ownerService")
@ApplicationScoped
public class OwnerServiceImpl implements OwnerService, Serializable {

    private static final long serialVersionUID = -553095693269912269L;

    @Inject
    private PetRepository petRepository;

    @Inject
    private OwnerRepository ownerRepository;

    @Override
    public List<Pet> getPetsAsList(@NotNull Owner owner){
        return petRepository.findBy(owner);
    }

    @Override
    public List<Owner> getAll() {
        return this.ownerRepository.findAll().toList();
    }

    @Override
    public void delete(long id) {
        this.ownerRepository.deleteById(id);
    }

    @Override
    public Owner addNew(Owner owner) {
        owner.updateSearchindex();
        log.info("addNew Owner: " + owner);
        return this.ownerRepository.insert(owner);
    }

    @Override
    public Optional<Owner> findById(long id) {
        return this.ownerRepository.findById(id);
    }

    @Override
    public Owner update(Owner owner) {
        owner.updateSearchindex();
        log.info("update Owner: " + owner);
        return this.ownerRepository.update(owner);
    }

    @Override
    public List<Owner> search(String searchterm) {
        return this.ownerRepository.findBySearchindexLike(searchterm);
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
