/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository.vdo;

import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetTypeRepository;

import com.vmware.vdo.jpa.spring.repository.VirtualRepository;

/**
 * @author akanchev
 */
public interface VdoPetTypeRepository extends VirtualRepository<PetType, Integer>, PetTypeRepository {

}
