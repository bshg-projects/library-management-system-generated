package org.bshg.librarysystem.transaction.sprocess.delete;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

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
        if (client != null && client.getId() != null) {
            service.deleteByClientId(client.getId());
        }
    }

    private ClientService clientService;
    private DeleteClientProcess deleteClientProcess;

    public void setDeleteClientProcess(DeleteClientProcess value) {
        this.deleteClientProcess = value;
    }
}