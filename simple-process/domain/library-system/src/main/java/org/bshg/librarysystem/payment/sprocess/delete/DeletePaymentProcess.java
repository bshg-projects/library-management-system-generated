package org.bshg.librarysystem.payment.sprocess.delete;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.payment.Payment;

import java.util.List;

public interface DeletePaymentProcess {
    void run(Payment item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Payment> items);

    void deleteByClient(Client client);
}