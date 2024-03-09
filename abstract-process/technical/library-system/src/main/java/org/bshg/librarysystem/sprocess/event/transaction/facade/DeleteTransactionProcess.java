package org.bshg.librarysystem.sprocess.event.transaction.facade;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.user.Client;
public interface DeleteTransactionProcess extends IDeleteProcess<Transaction> {
void deleteByClient(Client client);
}