package org.springframework.samples.petclinic.model;

import javax.persistence.metamodel.*;

@StaticMetamodel(PetType.class)
public class PetType_
{
    public static volatile SingularAttribute<PetType, Long> serialVersionUID;
    public static volatile SingularAttribute<PetType, java.lang.Integer> id;
    public static volatile SingularAttribute<PetType, java.lang.String> name;
}
