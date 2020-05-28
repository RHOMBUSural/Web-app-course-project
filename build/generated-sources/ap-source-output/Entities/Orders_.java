package Entities;

import Entities.People;
import Entities.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-09T21:51:51")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> idOrder;
    public static volatile SingularAttribute<Orders, Date> shippingDate;
    public static volatile SingularAttribute<Orders, Product> idProduct;
    public static volatile SingularAttribute<Orders, People> idPeople;
    public static volatile SingularAttribute<Orders, Integer> countProducts;
    public static volatile SingularAttribute<Orders, Integer> noOrders;

}