package org.bshg.librarysystem.transaction.sprocess.update;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.update.UpdateTransactionProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateTransactionProcessImpl extends AbstractUpdateProcessImpl<Transaction, TransactionService> implements UpdateTransactionProcess {
public UpdateTransactionProcessImpl(TransactionService service, ClientService clientService) {
super(service);
this.clientService = clientService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Transaction run(Transaction item) {
// Your Update Logic For 'Transaction'
item = service.edit(item);
return item;
}
private ClientService clientService;
private UpdateClientProcess updateClientProcess;
private DeleteClientProcess deleteClientProcess;
public void setUpdateClientProcess(UpdateClientProcess value) {
this.updateClientProcess = value;
}
public void setDeleteClientProcess(DeleteClientProcess value) {
this.deleteClientProcess = value;
}
}