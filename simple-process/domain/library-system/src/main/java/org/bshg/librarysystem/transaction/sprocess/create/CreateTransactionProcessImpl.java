package org.bshg.librarysystem.transaction.sprocess.create;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.create.CreateTransactionProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.Client;
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