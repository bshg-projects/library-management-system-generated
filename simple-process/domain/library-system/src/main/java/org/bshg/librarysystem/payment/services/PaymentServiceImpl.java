package org.bshg.librarysystem.payment.services;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.PaymentDao;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
@Autowired PaymentDao dao;
@Override
public Payment findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Payment> findAll() {
return dao.findAll();
}
public List<Payment> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Payment create(Payment item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Payment edit(Payment item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Payment item) {
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
public void delete(List<Payment> list) {
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
public List<Payment> findByClientId(Long id){
return dao.findByClientId(id);
}
@Autowired private ClientService clientService;
}