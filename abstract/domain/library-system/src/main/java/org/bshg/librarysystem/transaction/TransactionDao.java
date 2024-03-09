package org.bshg.librarysystem.transaction;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface TransactionDao extends Repository<Transaction, Long> {
int deleteByClientId(Long id);
List<Transaction> findByClientId(Long id);
@Query("SELECT NEW Transaction(item.id,item.name) FROM Transaction item")
List<Transaction> findAllOptimized();
}