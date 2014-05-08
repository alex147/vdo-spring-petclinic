/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetTypeRepository;

/**
 * @author akanchev
 */
public class JpaPetTypeRepositoryImpl implements PetTypeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<PetType> findPetTypes() {
        return this.em.createQuery("SELECT ptype FROM PetType ptype ORDER BY ptype.name").getResultList();
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.samples.petclinic.repository.PetTypeRepository#save(org.springframework.samples.petclinic
     * .model.PetType)
     */
    @Override
    public PetType save(PetType petType) throws DataAccessException {
        // TODO Auto-generated method stub
        return null;
    }

}
