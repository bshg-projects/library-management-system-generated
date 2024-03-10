package org.bshg.librarysystem.sprocess.event.payment.delete;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeletePaymentProcess extends IDeleteProcess<Payment> {
    void deleteByClient(Client client);
}