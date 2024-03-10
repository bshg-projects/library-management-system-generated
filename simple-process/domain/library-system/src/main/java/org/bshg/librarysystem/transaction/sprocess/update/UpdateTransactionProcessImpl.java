package org.bshg.librarysystem.transaction.sprocess.update;

import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
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