package org.bshg.librarysystem.sprocess.event.transaction.update;

import org.bshg.librarysystem.entity.core.event.Transaction;

import java.util.List;

public interface UpdateTransactionProcess {
    Transaction run(Transaction item);

    List<Transaction> run(List<Transaction> items);
}
