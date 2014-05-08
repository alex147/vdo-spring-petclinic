/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.util;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Treatment;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;

/**
 * A helper class used for populating the database before running tests or deploying the application.
 * 
 * @author akanchev
 */
public class DbPopulatingUtil {

    public void populate() {

        if (!singletonBoolean.getIsSetUp()) {

            List<Vet> vets = populateVets();
            populateOwners(vets);
            populateTreatments();
            singletonBoolean.setUp();
        }
    }

    private void populateTreatments() {

        Treatment treatment1 = new Treatment(new Integer(1), "vaccination", 23.75);
        clinicService.saveTreatment(treatment1);

        Treatment treatment2 = new Treatment(new Integer(2), "bandage broken leg", 47.50);
        clinicService.saveTreatment(treatment2);

        Treatment treatment3 = new Treatment(new Integer(3), "neutering", 33.00);
        clinicService.saveTreatment(treatment3);

    }

    private void populateOwners(List<Vet> vets) {

        List<PetType> petTypes = initializePetTypes();
        List<Visit> visits = initializeVisits(vets);
        List<Pet> pets = initializePets(petTypes, visits);

        Owner owner1 = new Owner("George", "Franklin", "110 W. Liberty St.", "Madison", "6085551023");
        owner1.addPet(pets.get(0));
        clinicService.saveOwner(owner1);

        Owner owner2 = new Owner("Betty", "Davis", "638 Cardinal Ave.", "Sun Prairie", "6085551749");
        owner2.addPet(pets.get(1));
        clinicService.saveOwner(owner2);

        Owner owner3 = new Owner("Eduardo", "Rodriquez", "2693 Commerce St.", "McFarland", "6085558763");
        owner3.addPet(pets.get(2));
        owner3.addPet(pets.get(3));
        clinicService.saveOwner(owner3);

        Owner owner4 = new Owner("Harold", "Davis", "563 Friendly St.", "Windsor", "6085553198");
        owner4.addPet(pets.get(4));
        clinicService.saveOwner(owner4);

        Owner owner5 = new Owner("Peter", "McTavish", "2387 S. Fair Way", "Madison", "6085552765");
        owner5.addPet(pets.get(5));
        clinicService.saveOwner(owner5);

        Owner owner6 = new Owner("Jean", "Coleman", "105 N. Lake St.", "Monona", "6085552654");
        owner6.addPet(pets.get(6));
        owner6.addPet(pets.get(7));
        clinicService.saveOwner(owner6);

        Owner owner7 = new Owner("Jeff", "Black", "1450 Oak Blvd.", "Monona", "6085555387");
        owner7.addPet(pets.get(8));
        clinicService.saveOwner(owner7);

        Owner owner8 = new Owner("Maria", "Escobito", "345 Maple St.", "Madison", "6085557683");
        owner8.addPet(pets.get(9));
        clinicService.saveOwner(owner8);

        Owner owner9 = new Owner("David", "Schroeder", "2749 Blackhawk Trail", "Madison", "6085559435");
        owner9.addPet(pets.get(10));
        clinicService.saveOwner(owner9);

        Owner owner10 = new Owner("Carlos", "Estaban", "2335 Independence La.", "Waunakee", "6085555487");
        owner10.addPet(pets.get(11));
        owner10.addPet(pets.get(12));
        clinicService.saveOwner(owner10);
    }

    private List<PetType> initializePetTypes() {

        List<PetType> petTypes = new ArrayList<PetType>();

        PetType petType1 = new PetType("cat");
        petTypes.add(petType1);
        clinicService.savePetType(petType1);

        PetType petType2 = new PetType("dog");
        petTypes.add(petType2);
        clinicService.savePetType(petType2);

        PetType petType3 = new PetType("lizard");
        petTypes.add(petType3);
        clinicService.savePetType(petType3);

        PetType petType4 = new PetType("snake");
        petTypes.add(petType4);
        clinicService.savePetType(petType4);

        PetType petType5 = new PetType("bird");
        petTypes.add(petType5);
        clinicService.savePetType(petType5);

        PetType petType6 = new PetType("hamster");
        petTypes.add(petType6);
        clinicService.savePetType(petType6);

        return petTypes;
    }

    private List<Visit> initializeVisits(List<Vet> vets) {

        List<Visit> visits = new ArrayList<Visit>();

        Visit visit1 = new Visit(new DateTime("2010-03-04"), "rabies shot");
        visits.add(visit1);

        Visit visit2 = new Visit(new DateTime("2011-03-04"), "rabies shot");
        visits.add(visit2);

        Visit visit3 = new Visit(new DateTime("2009-06-04"), "neutered");
        visits.add(visit3);

        Visit visit4 = new Visit(new DateTime("2008-09-04"), "spayed");
        visits.add(visit4);

        return visits;
    }

    private List<Pet> initializePets(List<PetType> petTypes, List<Visit> visits) {

        List<Pet> pets = new ArrayList<Pet>();

        Pet pet1 = new Pet("Leo", new DateTime("2000-09-07"));
        pet1.setType(petTypes.get(0));
        pets.add(pet1);
        clinicService.savePet(pet1);

        Pet pet2 = new Pet("Basil", new DateTime("2002-08-06"));
        pet2.setType(petTypes.get(5));
        pets.add(pet2);
        clinicService.savePet(pet2);

        Pet pet3 = new Pet("Rosy", new DateTime("2001-04-17"));
        pet3.setType(petTypes.get(1));
        pets.add(pet3);
        clinicService.savePet(pet3);

        Pet pet4 = new Pet("Jewel", new DateTime("2000-03-07"));
        pet4.setType(petTypes.get(1));
        pets.add(pet4);
        clinicService.savePet(pet4);

        Pet pet5 = new Pet("Iggy", new DateTime("2000-11-30"));
        pet5.setType(petTypes.get(2));
        pets.add(pet5);
        clinicService.savePet(pet5);

        Pet pet6 = new Pet("George", new DateTime("2000-01-20"));
        pet6.setType(petTypes.get(3));
        pets.add(pet6);
        clinicService.savePet(pet6);

        Pet pet7 = new Pet("Samantha", new DateTime("1995-09-04"));
        pet7.setType(petTypes.get(0));
        pet7.addVisit(visits.get(0));
        pet7.addVisit(visits.get(3));
        pets.add(pet7);
        clinicService.savePet(pet7);

        Pet pet8 = new Pet("Max", new DateTime("1995-09-04"));
        pet8.setType(petTypes.get(0));
        pet8.addVisit(visits.get(1));
        pet8.addVisit(visits.get(2));
        pets.add(pet8);
        clinicService.savePet(pet8);

        Pet pet9 = new Pet("Lucky", new DateTime("1999-08-06"));
        pet9.setType(petTypes.get(4));
        pets.add(pet9);
        clinicService.savePet(pet9);

        Pet pet10 = new Pet("Mulligan", new DateTime("1997-02-24"));
        pet10.setType(petTypes.get(1));
        pets.add(pet10);
        clinicService.savePet(pet10);

        Pet pet11 = new Pet("Freddy", new DateTime("2000-03-09"));
        pet11.setType(petTypes.get(4));
        pets.add(pet11);
        clinicService.savePet(pet11);

        Pet pet12 = new Pet("Lucky", new DateTime("2000-06-24"));
        pet12.setType(petTypes.get(1));
        pets.add(pet12);
        clinicService.savePet(pet12);

        Pet pet13 = new Pet("Sly", new DateTime("2002-06-08"));
        pet13.setType(petTypes.get(0));
        pets.add(pet13);
        clinicService.savePet(pet13);

        return pets;
    }

    private List<Vet> populateVets() {

        List<Specialty> specialties = initializeSpecialties();
        List<Vet> vets = new ArrayList<Vet>();

        Vet vet1 = new Vet("James", "Carter");
        clinicService.saveVet(vet1);
        vets.add(vet1);

        Vet vet2 = new Vet("Helen", "Leary");
        vet2.addSpecialty(specialties.get(0));
        clinicService.saveVet(vet2);
        vets.add(vet2);

        Vet vet3 = new Vet("Linda", "Douglas");
        vet3.addSpecialty(specialties.get(1));
        vet3.addSpecialty(specialties.get(2));
        clinicService.saveVet(vet3);
        vets.add(vet3);

        Vet vet4 = new Vet("Rafael", "Ortega");
        vet4.addSpecialty(specialties.get(1));
        clinicService.saveVet(vet4);
        vets.add(vet4);

        Vet vet5 = new Vet("Henry", "Stevens");
        vet5.addSpecialty(specialties.get(0));
        clinicService.saveVet(vet5);
        vets.add(vet5);

        Vet vet6 = new Vet("Sharon", "Jenkins");
        clinicService.saveVet(vet6);
        vets.add(vet6);

        return vets;
    }

    private List<Specialty> initializeSpecialties() {

        List<Specialty> specialties = new ArrayList<Specialty>();

        Specialty specialty1 = new Specialty("radiology");
        specialties.add(specialty1);

        Specialty specialty2 = new Specialty("surgery");
        specialties.add(specialty2);

        Specialty specialty3 = new Specialty("dentistry");
        specialties.add(specialty3);

        return specialties;
    }

    @Autowired
    private ClinicService clinicService;
    private final SingletonBoolean singletonBoolean = SingletonBoolean.getInstance();
}