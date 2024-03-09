
package org.bshg.librarysystem.sprocess.event.transaction.delete;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteTransactionProcessImpl extends AbstractDeleteProcessImpl<Transaction, TransactionService> implements DeleteTransactionProcess {
public DeleteTransactionProcessImpl(TransactionService service, ClientService clientService) {
super(service);
this.clientService = clientService;
}
@Override
protected void process(Transaction item) {
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