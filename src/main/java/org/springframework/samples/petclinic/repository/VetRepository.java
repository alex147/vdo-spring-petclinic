/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vet;

/**
 * @author akanchev
 */
public interface VetRepository {

    /**
     * Retrieve all <code>Vet</code>s from the data store.
     * 
     * @return a <code>Collection</code> of <code>Vet</code>s
     */
    public Collection<Vet> findVets() throws DataAccessException;

    /**
     * Save a <code>Vet</code> to the data store, either inserting or updating it.
     * 
     * @param vet
     *            the <code>Vet</code> to save
     * @see Vet#isNew()
     */
    Vet save(Vet vet) throws DataAccessException;
}
