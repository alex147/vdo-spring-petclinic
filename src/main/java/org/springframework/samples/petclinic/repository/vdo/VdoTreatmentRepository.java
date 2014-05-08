/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.repository.vdo;

import org.springframework.samples.petclinic.model.Treatment;
import org.springframework.samples.petclinic.repository.TreatmentRepository;

import com.vmware.vdo.jpa.spring.repository.VirtualRepository;

/**
 * @author akanchev
 */
public interface VdoTreatmentRepository extends TreatmentRepository, VirtualRepository<Treatment, Integer> {

}
