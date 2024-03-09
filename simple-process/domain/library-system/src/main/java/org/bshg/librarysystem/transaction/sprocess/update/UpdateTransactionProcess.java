package org.bshg.librarysystem.transaction.sprocess.update;

import org.bshg.librarysystem.transaction.Transaction;
import java.util.List;

public interface UpdateTransactionProcess {
    Transaction run(Transaction item);
    List<Transaction> run(List<Transaction> items);
}
