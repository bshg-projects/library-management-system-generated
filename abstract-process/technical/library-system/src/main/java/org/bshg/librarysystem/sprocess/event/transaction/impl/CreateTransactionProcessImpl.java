package org.bshg.librarysystem.sprocess.event.transaction.impl;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.event.transaction.facade.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
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