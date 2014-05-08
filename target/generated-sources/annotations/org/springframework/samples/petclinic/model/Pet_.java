package org.springframework.samples.petclinic.model;

import javax.persistence.metamodel.*;

@StaticMetamodel(Pet.class)
public class Pet_
{
    public static volatile SingularAttribute<Pet, Long> serialVersionUID;
    public static volatile SingularAttribute<Pet, org.joda.time.DateTime> birthDate;
    public static volatile SingularAttribute<Pet, org.springframework.samples.petclinic.model.PetType> type;
    public static volatile SingularAttribute<Pet, org.springframework.samples.petclinic.model.Owner> owner;
    public static volatile SetAttribute<Pet, org.springframework.samples.petclinic.model.Visit> visits;
    public static volatile SingularAttribute<Pet, java.lang.Integer> id;
    public static volatile SingularAttribute<Pet, java.lang.String> name;
}
