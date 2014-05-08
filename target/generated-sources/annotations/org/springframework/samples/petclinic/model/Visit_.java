package org.springframework.samples.petclinic.model;

import javax.persistence.metamodel.*;

@StaticMetamodel(Visit.class)
public class Visit_
{
    public static volatile SingularAttribute<Visit, Long> serialVersionUID;
    public static volatile SingularAttribute<Visit, org.joda.time.DateTime> date;
    public static volatile SingularAttribute<Visit, java.lang.String> description;
    public static volatile SingularAttribute<Visit, org.springframework.samples.petclinic.model.Pet> pet;
    public static volatile SingularAttribute<Visit, java.lang.Integer> id;
}
