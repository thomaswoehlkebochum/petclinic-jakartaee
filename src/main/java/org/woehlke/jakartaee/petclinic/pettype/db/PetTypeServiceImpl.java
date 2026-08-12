package org.woehlke.jakartaee.petclinic.pettype.db;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.pettype.PetType;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.io.Serializable;
import java.util.*;

/**
 *
 */
@Log
@Named("petTypeService")
@ApplicationScoped
@Transactional
public class PetTypeServiceImpl implements PetTypeService, Serializable  {

    private static final long serialVersionUID = -6242995649030237034L;

    @Inject
    private PetTypeRepository petTypeRepository;

    @Override
    public List<PetType> getAll() {
        List<PetType> all = new ArrayList<>(petTypeRepository.findAll().toList());
        Collections.sort(all);
        return all;
    }

    @Override
    public void delete(long id) {
        log.info("delete PetType: " + id);
        this.petTypeRepository.deleteById(id);
    }

    @Override
    public PetType addNew(PetType petType) {
        log.info("addNew PetType: " + petType.toString());
        petType.updateSearchindex();
        return this.petTypeRepository.insert(petType);
    }

    @Override
    public Optional<PetType> findById(long id) {
        return this.petTypeRepository.findById(id);
    }

    @Override
    public PetType update(PetType petType) {
        petType.updateSearchindex();
        log.info("update: " + petType);
        return this.petTypeRepository.update(petType);
    }

    @Override
    public List<PetType> search(String searchterm) {
        return this.petTypeRepository.findBySearchindexLike(searchterm);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+PetTypeServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+PetTypeServiceImpl.class.getSimpleName());
    }
}
