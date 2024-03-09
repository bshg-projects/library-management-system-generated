package org.bshg.librarysystem.sprocess.event.transaction.impl;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.facade.UpdateTransactionProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private TransactionService service;
}