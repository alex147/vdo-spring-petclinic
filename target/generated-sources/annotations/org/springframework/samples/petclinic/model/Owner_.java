package org.springframework.samples.petclinic.model;

import javax.persistence.metamodel.*;

@StaticMetamodel(Owner.class)
public class Owner_
{
    public static volatile SingularAttribute<Owner, Long> serialVersionUID;
    public static volatile SingularAttribute<Owner, java.lang.String> address;
    public static volatile SingularAttribute<Owner, java.lang.String> city;
    public static volatile SingularAttribute<Owner, java.lang.String> telephone;
    public static volatile ListAttribute<Owner, org.springframework.samples.petclinic.model.Pet> pets;
    public static volatile SingularAttribute<Owner, java.lang.Integer> id;
    public static volatile SingularAttribute<Owner, java.lang.String> firstName;
    public static volatile SingularAttribute<Owner, java.lang.String> lastName;
}
