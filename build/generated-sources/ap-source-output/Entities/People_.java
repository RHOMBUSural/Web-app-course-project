package Entities;

import Entities.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-09T21:51:51")
@StaticMetamodel(People.class)
public class People_ { 

    public static volatile SingularAttribute<People, String> phone;
    public static volatile SingularAttribute<People, String> name;
    public static volatile SingularAttribute<People, Integer> idPeople;
    public static volatile CollectionAttribute<People, Orders> ordersCollection;
    public static volatile SingularAttribute<People, String> email;

}