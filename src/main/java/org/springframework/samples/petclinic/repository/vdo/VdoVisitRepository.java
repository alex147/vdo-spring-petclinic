/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository.vdo;

import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VisitRepository;

import com.vmware.vdo.jpa.spring.repository.VirtualRepository;

/**
 * vDO specialization of the {@link VisitRepository} interface
 * 
 * @author akanchev
 */
public interface VdoVisitRepository extends VisitRepository, VirtualRepository<Visit, Integer> {

}
