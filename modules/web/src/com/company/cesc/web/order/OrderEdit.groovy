package com.company.cesc.web.order

import com.company.cesc.entity.Order
import com.company.cesc.entity.OrderStatus
import com.haulmont.cuba.core.global.Security
import com.haulmont.cuba.gui.components.AbstractEditor
import com.haulmont.cuba.gui.components.Frame

import javax.inject.Inject

class OrderEdit extends AbstractEditor<Order> {

    @Inject
    Security security


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

    /**
     * You should not put the security logic into the controller. Think about the REST API e.g.
     *
     * For more information @see https://www.road-to-cuba-and-beyond.com/cuba-security-subsystem-distilled-2/
     */
//    @Override
//    protected boolean preCommit() {
//        if (item.closed) {
//            showNotification("No no, you cannot do that", Frame.NotificationType.ERROR)
//            false
//        }
//        else {
//            showNotification("That works out quite well", Frame.NotificationType.TRAY)
//            true
//        }
//    }
}