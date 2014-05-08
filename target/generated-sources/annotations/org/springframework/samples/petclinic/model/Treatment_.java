package org.springframework.samples.petclinic.model;

import javax.persistence.metamodel.*;

@StaticMetamodel(Treatment.class)
public class Treatment_
{
    public static volatile SingularAttribute<Treatment, java.lang.Integer> id;
    public static volatile SingularAttribute<Treatment, java.lang.String> name;
    public static volatile SingularAttribute<Treatment, Double> price;
}
