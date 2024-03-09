package org.bshg.librarysystem.sprocess.event.payment.delete;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.user.Client;
public interface DeletePaymentProcess extends IDeleteProcess<Payment> {
void deleteByClient(Client client);
}