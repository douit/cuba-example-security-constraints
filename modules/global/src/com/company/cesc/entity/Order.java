package com.company.cesc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Listeners;

@Listeners("cesc_OrderEntityListener")
@NamePattern("%s|orderDate")
@Table(name = "CESC_ORDER")
@Entity(name = "cesc$Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -706733610356021397L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    protected Date orderDate;

    @Column(name = "STATUS")
    protected String status;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected Set<LineItem> lineItems;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @Column(name = "PAYMENT_METHOD")
    protected String paymentMethod;

    @Column(name = "CLOSED")
    protected Boolean closed;

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getClosed() {
        return closed;
    }


    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.getId();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod == null ? null : PaymentMethod.fromId(paymentMethod);
    }


    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }


    public void setStatus(OrderStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public OrderStatus getStatus() {
        return status == null ? null : OrderStatus.fromId(status);
    }


    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }


}