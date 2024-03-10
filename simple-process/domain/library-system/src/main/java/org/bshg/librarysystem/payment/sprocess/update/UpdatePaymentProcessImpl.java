package org.bshg.librarysystem.payment.sprocess.update;

import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
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