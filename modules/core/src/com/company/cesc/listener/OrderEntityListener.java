package com.company.cesc.listener;

import com.company.cesc.entity.OrderStatus;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.cesc.entity.Order;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;

@Component("cesc_OrderEntityListener")
public class OrderEntityListener implements BeforeInsertEntityListener<Order>, BeforeUpdateEntityListener<Order> {


    @Override
    public void onBeforeInsert(Order entity, EntityManager entityManager) {

        if (entity.getStatus() == OrderStatus.CLOSED) {
            entity.setClosed(true);
        }
    }


    @Override
    public void onBeforeUpdate(Order entity, EntityManager entityManager) {

        if (entity.getStatus() == OrderStatus.CLOSED) {
            entity.setClosed(true);
        }
    }


}