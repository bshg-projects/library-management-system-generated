package org.bshg.librarysystem.payment.sprocess.update;

import org.bshg.librarysystem.payment.Payment;

import java.util.List;

public interface UpdatePaymentProcess {
    Payment run(Payment item);

    List<Payment> run(List<Payment> items);
}
