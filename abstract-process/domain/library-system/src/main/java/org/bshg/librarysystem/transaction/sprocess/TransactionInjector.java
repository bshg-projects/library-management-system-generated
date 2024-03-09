package org.bshg.librarysystem.transaction.sprocess;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.create.CreateTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.update.UpdateTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.create.CreateTransactionProcessImpl;
import org.bshg.librarysystem.transaction.sprocess.update.UpdateTransactionProcessImpl;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcessImpl;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Transaction Processes (Create, Update, Delete).
*/
@Configuration
public class TransactionInjector {
@Bean
public CreateTransactionProcess createTransactionProcess (TransactionService service,ClientService clientService) {
var bean = new CreateTransactionProcessImpl(service, clientService);
bean.setCreateClientProcess(this.createClientProcess);
return bean;
}
@Bean
public UpdateTransactionProcess updateTransactionProcess (TransactionService service,ClientService clientService) {
var bean = new UpdateTransactionProcessImpl(service,clientService);
bean.setUpdateClientProcess(this.updateClientProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Bean
public DeleteTransactionProcess deleteTransactionProcess(TransactionService service,ClientService clientService) {
var bean = new DeleteTransactionProcessImpl(service,clientService);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Autowired @Lazy private CreateClientProcess createClientProcess;
@Autowired @Lazy private UpdateClientProcess updateClientProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
}