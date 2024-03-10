package org.bshg.librarysystem.sprocess.event.transaction.create;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateTransactionProcessImpl implements CreateTransactionProcess {
    @Transactional(rollbackFor = Exception.class)
    public Transaction run(Transaction item) {
// Your Creation Logic For 'Transaction'
        item = service.create(item);
        return item;
    }

    public List<Transaction> run(List<Transaction> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private TransactionService service;
    @Autowired
    private ClientService clientService;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
}