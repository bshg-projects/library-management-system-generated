package org.bshg.librarysystem.repository.event;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface TransactionDao extends Repository<Transaction, Long> {
int deleteByClientId(Long id);
List<Transaction> findByClientId(Long id);
@Query("SELECT NEW Transaction(item.id,item.name) FROM Transaction item")
List<Transaction> findAllOptimized();
}