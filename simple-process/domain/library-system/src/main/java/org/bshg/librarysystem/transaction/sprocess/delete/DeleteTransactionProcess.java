package org.bshg.librarysystem.transaction.sprocess.delete;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.transaction.Transaction;

import java.util.List;

public interface DeleteTransactionProcess {
    void run(Transaction item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Transaction> items);

    void deleteByClient(Client client);
}