package org.bshg.librarysystem.sprocess.event.transaction;

import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.event.transaction.facade.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.UpdateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.impl.CreateTransactionProcessImpl;
import org.bshg.librarysystem.sprocess.event.transaction.impl.DeleteTransactionProcessImpl;
import org.bshg.librarysystem.sprocess.event.transaction.impl.UpdateTransactionProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Transaction Processes (Create, Update, Delete).
 */
@Configuration
public class TransactionInjector {
    @Bean
    public CreateTransactionProcess createTransactionProcess(TransactionService service, ClientService clientService) {
        var bean = new CreateTransactionProcessImpl(service, clientService);
        bean.setCreateClientProcess(this.createClientProcess);
        return bean;
    }

    @Bean
    public UpdateTransactionProcess updateTransactionProcess(TransactionService service, ClientService clientService) {
        var bean = new UpdateTransactionProcessImpl(service, clientService);
        bean.setUpdateClientProcess(this.updateClientProcess);
        bean.setDeleteClientProcess(this.deleteClientProcess);
        return bean;
    }

    @Bean
    public DeleteTransactionProcess deleteTransactionProcess(TransactionService service, ClientService clientService) {
        var bean = new DeleteTransactionProcessImpl(service, clientService);
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