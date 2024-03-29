package org.bshg.librarysystem.sprocess.event.payment.impl;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.event.payment.facade.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreatePaymentProcessImpl implements CreatePaymentProcess {
    @Transactional(rollbackFor = Exception.class)
    public Payment run(Payment item) {
// Your Creation Logic For 'Payment'
        item = service.create(item);
        return item;
    }

    public List<Payment> run(List<Payment> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private PaymentService service;
    @Autowired
    private ClientService clientService;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
}