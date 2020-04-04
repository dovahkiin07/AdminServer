package com.mycompany.as1soapservice.models;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-03T19:16:40")
@StaticMetamodel(Shows.class)
public class Shows_ { 

    public static volatile SingularAttribute<Shows, byte[]> thumbnail;
    public static volatile SingularAttribute<Shows, String> director;
    public static volatile SingularAttribute<Shows, String> rating;
    public static volatile SingularAttribute<Shows, String> description;
    public static volatile SingularAttribute<Shows, BigDecimal> id;
    public static volatile SingularAttribute<Shows, String> title;
    public static volatile SingularAttribute<Shows, String> category;
    public static volatile SingularAttribute<Shows, String> type;

}