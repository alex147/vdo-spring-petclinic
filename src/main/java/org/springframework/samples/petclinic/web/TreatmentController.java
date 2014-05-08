/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Treatment;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author akanchev
 */
@Controller
public class TreatmentController {

    private final ClinicService clinicService;

    @Autowired
    public TreatmentController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = "/prices")
    public String showPriceList(Map<String, Object> model) {

        Collection<Treatment> treatments = this.clinicService.findTreatments();
        model.put("treatments", treatments);
        return "prices/priceList";
    }
}
