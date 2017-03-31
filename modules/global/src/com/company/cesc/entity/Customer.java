package com.company.cesc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CESC_CUSTOMER")
@Entity(name = "cesc$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 4383299665507098133L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "FIRSTNAME")
    protected String firstname;

    @Column(name = "STREET")
    protected String street;

    @Column(name = "POSTCODE")
    protected String postcode;

    @Column(name = "CITY")
    protected String city;

    @Column(name = "STATE")
    protected String state;

    @Column(name = "TYPE_")
    protected String type;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "customer")
    protected Set<Order> orders;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Order> getOrders() {
        return orders;
    }


    public void setType(CustomerType type) {
        this.type = type == null ? null : type.getId();
    }

    public CustomerType getType() {
        return type == null ? null : CustomerType.fromId(type);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}