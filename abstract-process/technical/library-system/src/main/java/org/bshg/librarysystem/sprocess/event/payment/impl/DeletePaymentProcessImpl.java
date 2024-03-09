
package org.bshg.librarysystem.sprocess.event.payment.impl;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.facade.DeletePaymentProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeletePaymentProcessImpl extends AbstractDeleteProcessImpl<Payment, PaymentService> implements DeletePaymentProcess {
public DeletePaymentProcessImpl(PaymentService service, ClientService clientService) {
super(service);
this.clientService = clientService;
}
@Override
protected void process(Payment item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
public void deleteByClient(Client client) {
if (client != null && client.getId() != null){
service.deleteByClientId(client.getId());
}
}
private ClientService clientService;
private DeleteClientProcess deleteClientProcess;
public void setDeleteClientProcess(DeleteClientProcess value) {
this.deleteClientProcess = value;
}
}