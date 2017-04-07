package com.company.cesc.web.order

import com.company.cesc.entity.Order
import com.company.cesc.entity.OrderStatus
import com.haulmont.cuba.core.global.Security
import com.haulmont.cuba.gui.components.AbstractEditor
import com.haulmont.cuba.gui.components.Frame
import com.haulmont.cuba.gui.components.Table
import com.haulmont.cuba.gui.data.CollectionDatasource

import javax.inject.Inject

class OrderEdit extends AbstractEditor<Order> {

    @Inject
    Table<Order> ordersTable

    @Inject
    CollectionDatasource<Order, UUID> ordersTableDs

    @Inject
    Security security

    @Override
    void ready() {
        ordersTable.selectAll()
    }

    void deliverOrder() {
        if (security.isPermitted(item, "deliverOrder")) {
            item.status = OrderStatus.DELIVERED
            showNotification("Order delivered...", Frame.NotificationType.TRAY)
            commitAndClose()
        }
        else {
            showNotification("Not allowed...", Frame.NotificationType.ERROR)
        }
    }
}