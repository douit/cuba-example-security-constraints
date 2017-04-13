package com.company.cesc.web.order

import com.company.cesc.entity.Order
import com.company.cesc.service.InvoiceService
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.Frame
import com.haulmont.cuba.gui.components.Table
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction
import com.haulmont.cuba.security.entity.ConstraintOperationType

import javax.inject.Inject

class OrderBrowse extends AbstractLookup {

    @Inject InvoiceService invoiceService
    @Inject Table<Order> ordersTable

    @Override
    void init(Map<String, Object> params) {
        ordersTable.addAction(new SendInvoiceAction())
    }

    protected class SendInvoiceAction extends ItemTrackingAction {

        SendInvoiceAction() {
            super("sendInvoiceAction");

            setConstraintOperationType(ConstraintOperationType.CUSTOM)
            setConstraintCode("sendInvoice")
            setIcon("font-icon:SEND_O")
            setCaption(formatMessage("sendInvoice"))
        }

        @Override
        void actionPerform(Component component) {
            invoiceService.sendInvoice(ordersTable.singleSelected)
            showNotification("Invoice send", Frame.NotificationType.TRAY)
        }
    }

}