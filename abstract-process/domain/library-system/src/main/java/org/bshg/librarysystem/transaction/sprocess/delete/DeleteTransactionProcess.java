package org.bshg.librarysystem.transaction.sprocess.delete;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteTransactionProcess extends IDeleteProcess<Transaction> {
    void deleteByClient(Client client);
}