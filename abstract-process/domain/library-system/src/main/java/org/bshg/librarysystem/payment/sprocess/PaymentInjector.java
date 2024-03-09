package org.bshg.librarysystem.payment.sprocess;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.create.CreatePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.update.UpdatePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.create.CreatePaymentProcessImpl;
import org.bshg.librarysystem.payment.sprocess.update.UpdatePaymentProcessImpl;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcessImpl;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
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