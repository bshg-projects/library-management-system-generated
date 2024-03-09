package org.bshg.librarysystem.sprocess.event.transaction.delete;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.user.Client;
import java.util.List;
public interface DeleteTransactionProcess {
void run(Transaction item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Transaction> items);
void deleteByClient(Client client);
}