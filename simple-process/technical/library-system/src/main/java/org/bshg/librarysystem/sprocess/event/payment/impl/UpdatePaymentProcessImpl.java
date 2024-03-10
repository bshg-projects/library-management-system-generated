package org.bshg.librarysystem.sprocess.event.payment.impl;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.facade.UpdatePaymentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdatePaymentProcessImpl implements UpdatePaymentProcess {
    @Transactional(rollbackFor = Exception.class)
    public Payment run(Payment item) { // Your Logic To Update 'Payment'
        item = service.edit(item);
        return item;
    }

    public List<Payment> run(List<Payment> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private PaymentService service;
}