package com.company.cesc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "CESC_LINE_ITEM")
@Entity(name = "cesc$LineItem")
public class LineItem extends StandardEntity {
    private static final long serialVersionUID = 7810094119313151448L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    @Column(name = "POSITION_", nullable = false)
    protected Integer position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID")
    protected Product product;

    @Column(name = "QUANTITY", nullable = false)
    protected Integer quantity;

    @Column(name = "QUANTITY_UNIT")
    protected String quantityUnit;

    @Column(name = "UNIT_PRICE", nullable = false)
    protected BigDecimal unitPrice;

    @Column(name = "TOTAL_PRICE", nullable = false)
    protected BigDecimal totalPrice;

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit == null ? null : quantityUnit.getId();
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit == null ? null : QuantityUnit.fromId(quantityUnit);
    }


    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }


}