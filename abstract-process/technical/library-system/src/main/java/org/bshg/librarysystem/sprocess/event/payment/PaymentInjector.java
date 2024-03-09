package org.bshg.librarysystem.sprocess.event.payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.facade.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.UpdatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.impl.CreatePaymentProcessImpl;
import org.bshg.librarysystem.sprocess.event.payment.impl.UpdatePaymentProcessImpl;
import org.bshg.librarysystem.sprocess.event.payment.impl.DeletePaymentProcessImpl;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Payment Processes (Create, Update, Delete).
*/
@Configuration
public class PaymentInjector {
@Bean
public CreatePaymentProcess createPaymentProcess (PaymentService service,ClientService clientService) {
var bean = new CreatePaymentProcessImpl(service, clientService);
bean.setCreateClientProcess(this.createClientProcess);
return bean;
}
@Bean
public UpdatePaymentProcess updatePaymentProcess (PaymentService service,ClientService clientService) {
var bean = new UpdatePaymentProcessImpl(service,clientService);
bean.setUpdateClientProcess(this.updateClientProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Bean
public DeletePaymentProcess deletePaymentProcess(PaymentService service,ClientService clientService) {
var bean = new DeletePaymentProcessImpl(service,clientService);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Autowired @Lazy private CreateClientProcess createClientProcess;
@Autowired @Lazy private UpdateClientProcess updateClientProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}