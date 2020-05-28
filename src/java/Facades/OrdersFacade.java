/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Orders;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Roman
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> {
    
    public List<Orders> findRangeOrders(Integer[] orders) {
        
        Integer a = orders[0];
        Integer b = orders[1]; 
    
        return em.createQuery(
                "SELECT c FROM Orders c WHERE  c.noOrders BETWEEN :a AND :b")
                .setParameter("a", a)
                .setParameter("b", b)
                .getResultList();
    }
    

    @PersistenceContext(unitName = "IgnashovRAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

   
    
}
