package com.company.cesc.service

import com.company.cesc.core.SecurityConstraintExtensionImpl
import com.company.cesc.entity.Order
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service(InvoiceService.NAME)
class InvoiceServiceBean implements InvoiceService {

    private final Logger log = LoggerFactory.getLogger(InvoiceServiceBean.class);

    @Override
    void sendInvoice(Order order) {
        log.info("Invoice for order [${order.instanceName}] send...")
    }
}