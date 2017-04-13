package com.company.cesc.service

import com.company.cesc.entity.Order


public interface InvoiceService {
    String NAME = "cesc_InvoiceService";

    void sendInvoice(Order order);
}