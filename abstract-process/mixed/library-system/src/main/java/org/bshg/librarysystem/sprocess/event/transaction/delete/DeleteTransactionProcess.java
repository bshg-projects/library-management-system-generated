package org.bshg.librarysystem.sprocess.event.transaction.delete;

import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteTransactionProcess extends IDeleteProcess<Transaction> {
    void deleteByClient(Client client);
}