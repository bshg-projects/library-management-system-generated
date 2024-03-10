package org.bshg.librarysystem.transaction.sprocess.create;

import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateTransactionProcessImpl extends AbstractCreateProcessImpl<Transaction, TransactionService> implements CreateTransactionProcess {
    public CreateTransactionProcessImpl(TransactionService service, ClientService clientService) {
        super(service);
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Transaction run(Transaction item) {
// Your Insert Logic For 'Transaction'
        item = service.create(item);
        return item;
    }

    private ClientService clientService;
    private CreateClientProcess createClientProcess;

    public void setCreateClientProcess(CreateClientProcess value) {
        this.createClientProcess = value;
    }
}