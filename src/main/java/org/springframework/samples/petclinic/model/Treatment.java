/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;

import com.vmware.vdb.compiler.jpa.EntityHint;
import com.vmware.vdb.compiler.jpa.EntityHints;

/**
 * @author akanchev
 */
@Entity
// @Table(name = "treatments")
@EntityHints({ @EntityHint(name = "vdb.partition", value = "true"), @EntityHint(name = "vdb.language", value = "JPA") })
@NamedQueries({ @NamedQuery(name = "Treatment.findTreatments", query = "SELECT treatment FROM Treatment treatment ORDER BY treatment.name", hints = { @QueryHint(name = "vdb.language", value = "JPA") }) })
public class Treatment {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public Treatment() {

    }

    public Treatment(Integer id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
