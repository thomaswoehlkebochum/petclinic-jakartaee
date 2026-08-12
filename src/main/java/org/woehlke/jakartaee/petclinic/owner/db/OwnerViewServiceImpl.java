package org.woehlke.jakartaee.petclinic.owner.db;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.woehlke.jakartaee.petclinic.owner.Owner;
import org.woehlke.jakartaee.petclinic.pet.Pet;
import org.woehlke.jakartaee.petclinic.pet.db.PetRepository;
import org.woehlke.jakartaee.petclinic.pettype.PetType;
import org.woehlke.jakartaee.petclinic.pettype.db.PetTypeRepository;
import org.woehlke.jakartaee.petclinic.visit.Visit;
import org.woehlke.jakartaee.petclinic.visit.db.VisitRepository;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Log
@Named("ownerViewService")
@ApplicationScoped
@Transactional
public class OwnerViewServiceImpl implements OwnerViewService, Serializable {

    @Serial
    private static final long serialVersionUID = -553095668269912269L;

    @Inject
    private PetTypeRepository petTypeRepository;

    @Inject
    private OwnerRepository ownerRepository;

    @Inject
    private PetRepository petRepository;

    @Inject
    private VisitRepository visitRepository;

    @Override
    public void deleteOwner(long ownerId) {
        Owner owner = ownerRepository.findById(ownerId).get();
        for(Pet pet:petRepository.findByOwner(owner)){
            for(Visit visit:visitRepository.findByPet(pet)){
                visitRepository.delete(visit);
            }
            petRepository.delete(pet);
        }
        ownerRepository.delete(owner);
    }

    @Override
    public List<Owner> getAllOwner() {
        List<Owner> owners = new ArrayList<>(ownerRepository.findAll().toList());
        Collections.sort(owners);
        return owners;
    }

    @Override
    public Owner findOwnerById(long id) {
        return ownerRepository.findById(id).get();
    }

    @Override
    public Owner updateOwner(Owner entity) {
        entity.updateSearchindex();
        return ownerRepository.update(entity);
    }

    @Override
    public Owner addNewOwner(Owner entity) {
        entity.setUuid(UUID.randomUUID());
        entity.updateSearchindex();
        return ownerRepository.insert(entity);
    }

    @Override
    public List<Owner> searchOwner(String searchterm) {
        return ownerRepository.findBySearchindexLike(searchterm);
    }

    @Override
    public PetType findPetTypeById(long petTypeId) {
        return petTypeRepository.findById(petTypeId).get();
    }

    @Override
    public List<PetType> getAllPetType() {
        List<PetType> all = new ArrayList<>(petTypeRepository.findAll().toList());
        Collections.sort(all);
        return all;
    }

    @Override
    public List<Pet> getPetsAsList(Owner owner) {
        return petRepository.findByOwner(owner);
    }

    @Override
    public String getPetsAsString(Owner owner) {
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
    public Pet addNewPet(Pet pet) {
        pet.updateSearchindex();
        return petRepository.insert(pet);
    }

    @Override
    public Pet findPetById(long id) {
        return petRepository.findById(id).get();
    }

    @Override
    public Pet updatePet(Pet pet) {
        pet.updateSearchindex();
        return petRepository.update(pet);
    }

    @Override
    public List<Visit> getVisits(Pet ownersPet) {
        return visitRepository.findByPet(ownersPet);
    }

    @Override
    public Visit addNewVisit(Visit visit) {
        visit.updateSearchindex();
        visit.setUuid(UUID.randomUUID());
        return visitRepository.insert(visit);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct: "+OwnerViewServiceImpl.class.getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy: "+OwnerViewServiceImpl.class.getSimpleName());
    }
}
