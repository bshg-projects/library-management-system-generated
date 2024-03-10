package org.bshg.librarysystem.sprocess.event.transaction;

import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcessImpl;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcessImpl;
import org.bshg.librarysystem.sprocess.event.transaction.update.UpdateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.update.UpdateTransactionProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
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