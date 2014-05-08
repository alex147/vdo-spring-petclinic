/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.PetType;

/**
 * @author akanchev
 */
public interface PetTypeRepository {

    /**
     * Retrieve all <code>PetType</code>s from the data store.
     * 
     * @return a <code>Collection</code> of <code>PetType</code>s
     */
    List<PetType> findPetTypes() throws DataAccessException;

    /**
     * Save an <code>PetType</code> to the data store, either inserting or updating it.
     * 
     * @param petType
     *            the <code>PetType</code> to save
     * @see PetType#isNew()
     */
    PetType save(PetType petType) throws DataAccessException;

}
