/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Treatment;

/**
 * @author akanchev
 */
public interface TreatmentRepository {

    /**
     * Retrieve all <code>Treatment</code>s from the data store.
     * 
     * @return a <code>Collection</code> of <code>Treatment</code>s
     */
    List<Treatment> findTreatments() throws DataAccessException;

    /**
     * Save an <code>Treatment</code> to the data store, either inserting or updating it.
     * 
     * @param service
     *            the <code>Treatment</code> to save
     * @see Treatment#isNew()
     */
    Treatment save(Treatment treatment) throws DataAccessException;
}
