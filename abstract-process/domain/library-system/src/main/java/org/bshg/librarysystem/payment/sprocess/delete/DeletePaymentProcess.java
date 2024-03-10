package org.bshg.librarysystem.payment.sprocess.delete;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeletePaymentProcess extends IDeleteProcess<Payment> {
    void deleteByClient(Client client);
}