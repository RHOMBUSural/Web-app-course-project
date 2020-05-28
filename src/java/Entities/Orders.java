/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roman
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByIdOrder", query = "SELECT o FROM Orders o WHERE o.idOrder = :idOrder")
    , @NamedQuery(name = "Orders.findByCountProducts", query = "SELECT o FROM Orders o WHERE o.countProducts = :countProducts")
    , @NamedQuery(name = "Orders.findByShippingDate", query = "SELECT o FROM Orders o WHERE o.shippingDate = :shippingDate")
    , @NamedQuery(name = "Orders.findByNoOrders", query = "SELECT o FROM Orders o WHERE o.noOrders = :noOrders")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order", length = 100, nullable = false)
    private Integer idOrder;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "count_products", length = 100, nullable = false)
    private int countProducts;
    @Column(name = "shipping_date", length = 100, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date shippingDate;
    @Column(name = "no_orders", length = 100, nullable = false)
    private Integer noOrders;
    @JoinColumn(name = "id_people", referencedColumnName = "id_people")
    @ManyToOne(optional = false)
    private People idPeople;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private Product idProduct;

    public Orders() {
    }

    public Orders(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Orders(Integer idOrder, int countProducts) {
        this.idOrder = idOrder;
        this.countProducts = countProducts;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public int getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(int countProducts) {
        this.countProducts = countProducts;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Integer getNoOrders() {
        return noOrders;
    }

    public void setNoOrders(Integer noOrders) {
        this.noOrders = noOrders;
    }

    public People getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(People idPeople) {
        this.idPeople = idPeople;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Orders[ idOrder=" + idOrder + " ]";
    }
    
}
