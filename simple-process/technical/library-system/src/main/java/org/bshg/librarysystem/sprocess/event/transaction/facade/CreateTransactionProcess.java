package org.bshg.librarysystem.sprocess.event.transaction.facade;
import org.bshg.librarysystem.entity.core.event.Transaction;
import java.util.List;
public interface CreateTransactionProcess {
Transaction run(Transaction item);
List<Transaction> run(List<Transaction> items);
}