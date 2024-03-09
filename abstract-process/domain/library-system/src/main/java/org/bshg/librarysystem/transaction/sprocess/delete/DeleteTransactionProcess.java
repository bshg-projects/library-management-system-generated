package org.bshg.librarysystem.transaction.sprocess.delete;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.client.Client;
public interface DeleteTransactionProcess extends IDeleteProcess<Transaction> {
void deleteByClient(Client client);
}