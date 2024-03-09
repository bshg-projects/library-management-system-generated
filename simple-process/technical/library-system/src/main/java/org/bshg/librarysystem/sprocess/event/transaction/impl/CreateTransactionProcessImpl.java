package org.bshg.librarysystem.sprocess.event.transaction.impl;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.facade.CreateTransactionProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private TransactionService service;
@Autowired private ClientService clientService;
@Autowired @Lazy private CreateClientProcess createClientProcess;
}