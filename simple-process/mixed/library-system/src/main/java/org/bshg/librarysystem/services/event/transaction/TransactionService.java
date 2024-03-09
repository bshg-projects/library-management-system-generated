package org.bshg.librarysystem.services.event.transaction;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.user.Client;
import java.util.List;
public interface TransactionService {
Transaction findById(Long id);
List<Transaction> findAllOptimized();
List<Transaction> findAll();
Transaction create(Transaction item);
Transaction edit(Transaction item);
void deleteById(Long id);
void delete(Transaction item);
void delete(List<Transaction> items);
void deleteByIdIn(List<Long> ids);
int deleteByClientId(Long id);
List<Transaction> findByClientId(Long id);
}