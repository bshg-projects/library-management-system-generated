package org.bshg.librarysystem.sprocess.event.payment;

import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcessImpl;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcessImpl;
import org.bshg.librarysystem.sprocess.event.payment.update.UpdatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.update.UpdatePaymentProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Payment Processes (Create, Update, Delete).
 */
@Configuration
public class PaymentInjector {
    @Bean
    public CreatePaymentProcess createPaymentProcess(PaymentService service, ClientService clientService) {
        var bean = new CreatePaymentProcessImpl(service, clientService);
        bean.setCreateClientProcess(this.createClientProcess);
        return bean;
    }

    @Bean
    public UpdatePaymentProcess updatePaymentProcess(PaymentService service, ClientService clientService) {
        var bean = new UpdatePaymentProcessImpl(service, clientService);
        bean.setUpdateClientProcess(this.updateClientProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Bean
    public DeletePaymentProcess deletePaymentProcess(PaymentService service, ClientService clientService) {
        var bean = new DeletePaymentProcessImpl(service, clientService);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
    @Autowired
    @Lazy
    private UpdateClientProcess updateClientProcess;
    @Autowired
    @Lazy
    private DeleteClientProcess deleteClientProcess;
}