package org.woehlke.jakartaee.petclinic.vet.db;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.vet.Vet;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;


/**
 *
 */
@Log
@Named("vetService")
@ApplicationScoped
@Transactional
public class VetServiceImpl implements VetService, Serializable {

    @Serial
    private static final long serialVersionUID = 2698313227542867286L;

    @Inject
    private VetRepository vetRepository;

    @Override
    public List<Vet> getAll() {
        List<Vet> all = new ArrayList<>(vetRepository.findAll().toList());
        Collections.sort(all);
        return all;
    }

    @Override
    public Optional<Vet> findById(long id) {
        return this.vetRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        log.info("delete Vet: " + id);
        this.vetRepository.deleteById(id);
    }

    @Override
    public Vet addNew(Vet vet) {
        vet.setUuid(UUID.randomUUID());
        vet.updateSearchindex();
        log.info("try to addNew: " + vet);
        return this.vetRepository.insert(vet);
    }

    @Override
    public Vet update(Vet vet) {
        vet.updateSearchindex();
        log.info("update Vet: " + vet);
        return this.vetRepository.update(vet);
    }

    @Override
    public List<Vet> search(String searchterm) {
        log.info("search: " + searchterm);
        return this.vetRepository.findBySearchindexLike(searchterm);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+VetServiceImpl.class.getCanonicalName() );
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+VetServiceImpl.class.getCanonicalName() );
    }
}
