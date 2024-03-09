
package org.bshg.librarysystem.transaction.services;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.TransactionDao;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class TransactionServiceImpl extends ServiceImpl<Transaction, TransactionDao> implements TransactionService {
public TransactionServiceImpl(TransactionDao dao) {
super(dao);
}
@Override
public List<Transaction> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
return dao.deleteByClientId(id);
}
@Override
public List<Transaction> findByClientId(Long id){
return dao.findByClientId(id);
}
@Lazy @Autowired private ClientService clientService;
}