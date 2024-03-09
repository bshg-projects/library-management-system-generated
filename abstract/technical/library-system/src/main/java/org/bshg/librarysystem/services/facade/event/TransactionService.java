package org.bshg.librarysystem.services.facade.event;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface TransactionService extends IService<Transaction> {
int deleteByClientId(Long id);
List<Transaction> findByClientId(Long id);
}