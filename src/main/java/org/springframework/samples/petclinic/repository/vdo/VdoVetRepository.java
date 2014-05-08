/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository.vdo;

import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.VetRepository;

import com.vmware.vdo.jpa.spring.repository.VirtualRepository;

/**
 * @author akanchev
 */
public interface VdoVetRepository extends VirtualRepository<Vet, Integer>, VetRepository {

}
