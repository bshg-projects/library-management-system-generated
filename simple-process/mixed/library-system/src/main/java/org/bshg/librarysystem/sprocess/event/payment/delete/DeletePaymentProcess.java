package org.bshg.librarysystem.sprocess.event.payment.delete;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface DeletePaymentProcess {
    void run(Payment item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Payment> items);

    void deleteByClient(Client client);
}