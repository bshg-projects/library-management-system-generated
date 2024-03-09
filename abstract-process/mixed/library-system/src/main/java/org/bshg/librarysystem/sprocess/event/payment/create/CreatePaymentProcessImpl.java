package org.bshg.librarysystem.sprocess.event.payment.create;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreatePaymentProcessImpl extends AbstractCreateProcessImpl<Payment, PaymentService> implements CreatePaymentProcess {
public CreatePaymentProcessImpl(PaymentService service, ClientService clientService) {
super(service);
this.clientService = clientService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Payment run(Payment item) {
// Your Insert Logic For 'Payment'
item = service.create(item);
return item;
}
private ClientService clientService;
private CreateClientProcess createClientProcess;
public void setCreateClientProcess(CreateClientProcess value) {
this.createClientProcess = value;
}
}