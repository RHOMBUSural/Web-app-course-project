/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roman
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
    , @NamedQuery(name = "People.findByIdPeople", query = "SELECT p FROM People p WHERE p.idPeople = :idPeople")
    , @NamedQuery(name = "People.findByName", query = "SELECT p FROM People p WHERE p.name = :name")
    , @NamedQuery(name = "People.findByPhone", query = "SELECT p FROM People p WHERE p.phone = :phone")
    , @NamedQuery(name = "People.findByEmail", query = "SELECT p FROM People p WHERE p.email = :email")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_people", length = 100, nullable = false)
    private Integer idPeople;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 2147483647)
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    //@Size(max = 2147483647)
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    //@Size(max = 2147483647)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeople")
    private Collection<Orders> ordersCollection;

    public People() {
    }

    public People(Integer idPeople) {
        this.idPeople = idPeople;
    }

    public People(Integer idPeople, String name) {
        this.idPeople = idPeople;
        this.name = name;
    }

    public Integer getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(Integer idPeople) {
        this.idPeople = idPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeople != null ? idPeople.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.idPeople == null && other.idPeople != null) || (this.idPeople != null && !this.idPeople.equals(other.idPeople))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.People[ idPeople=" + idPeople + " ]";
    }
    
}
