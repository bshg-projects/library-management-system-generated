package org.bshg.librarysystem.transaction.sprocess.create;
import org.bshg.librarysystem.transaction.Transaction;
import java.util.List;
public interface CreateTransactionProcess {
Transaction run(Transaction item);
List<Transaction> run(List<Transaction> items);
}