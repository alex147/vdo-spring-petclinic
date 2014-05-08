package org.springframework.samples.petclinic.model;

import javax.persistence.metamodel.*;

@StaticMetamodel(Vet.class)
public class Vet_
{
    public static volatile SingularAttribute<Vet, java.lang.String> firstName;
    public static volatile SingularAttribute<Vet, java.lang.String> lastName;
    public static volatile SingularAttribute<Vet, java.lang.Integer> id;
    public static volatile ListAttribute<Vet, org.springframework.samples.petclinic.model.Specialty> specialties;
}
