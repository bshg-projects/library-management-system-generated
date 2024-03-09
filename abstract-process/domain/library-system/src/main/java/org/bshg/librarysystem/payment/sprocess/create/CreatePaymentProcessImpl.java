package org.bshg.librarysystem.payment.sprocess.create;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.create.CreatePaymentProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.Client;
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