package org.bshg.librarysystem.services.event.transaction;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.repository.event.TransactionDao;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
@Autowired TransactionDao dao;
@Override
public Transaction findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Transaction> findAll() {
return dao.findAll();
}
public List<Transaction> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Transaction create(Transaction item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Transaction edit(Transaction item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Transaction item) {
if (item == null)
return;
dao.deleteById(item.getId());
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(List<Transaction> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
return dao.deleteByClientId(id);
}
@Override
public List<Transaction> findByClientId(Long id){
return dao.findByClientId(id);
}
@Autowired private ClientService clientService;
}