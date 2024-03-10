package org.bshg.librarysystem.sprocess.event.payment.facade;

import org.bshg.librarysystem.entity.core.event.Payment;

import java.util.List;

public interface CreatePaymentProcess {
    Payment run(Payment item);

    List<Payment> run(List<Payment> items);
}