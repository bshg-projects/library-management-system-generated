package org.bshg.librarysystem.sprocess.event.transaction.update;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateTransactionProcessImpl implements UpdateTransactionProcess {
    @Transactional(rollbackFor = Exception.class)
    public Transaction run(Transaction item) { // Your Logic To Update 'Transaction'
        item = service.edit(item);
        return item;
    }

    public List<Transaction> run(List<Transaction> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private TransactionService service;
}