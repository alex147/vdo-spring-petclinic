/*
 * Copyright 2002-2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.vmware.vdb.compiler.jpa.EntityHint;
import com.vmware.vdb.compiler.jpa.EntityHints;

/**
 * Simple JavaBean domain object representing a visit.
 * 
 * @author Ken Krebs
 */
@Entity
@Table(name = "visits")
@EntityHints({ @EntityHint(name = "vdb.partition", value = "true"), @EntityHint(name = "vdb.language", value = "JPA") })
@NamedQueries({ @NamedQuery(name = "Visit.findByPetId", query = "SELECT distinct v FROM Visit v left join fetch v.pet pet where pet.id = ?1", hints = { @QueryHint(name = "vdb.language", value = "JPA") }) })
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Holds value of property date.
     */
    @Column(name = "visit_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private DateTime date;

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;

    /**
     * Holds value of property pet.
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Visit() {}

    public Visit(DateTime date, String description) {

        this.date = date;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    /**
     * Getter for property date.
     * 
     * @return Value of property date.
     */
    public DateTime getDate() {
        return this.date;
    }

    /**
     * Setter for property date.
     * 
     * @param date
     *            New value of property date.
     */
    public void setDate(DateTime date) {
        this.date = date;
    }

    /**
     * Getter for property description.
     * 
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     * 
     * @param description
     *            New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property pet.
     * 
     * @return Value of property pet.
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Setter for property pet.
     * 
     * @param pet
     *            New value of property pet.
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
