package org.bshg.librarysystem.payment.sprocess.create;

import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
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