package org.bshg.librarysystem.services.impl.event;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.repository.event.PaymentDao;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class PaymentServiceImpl implements PaymentService {
//--------------- FIND -------------------------------------
public Payment findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Payment> findAll() {
return dao.findAll();
}
public List<Payment> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Payment create(Payment item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Payment> create(List<Payment> items) {
List<Payment> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Payment update(Payment item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Payment> update(List<Payment> items) {
List<Payment> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Payment item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Payment item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Payment> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
return dao.deleteByClientId(id);
}
@Override
public List<Payment> findByClientId(Long id){
return dao.findByClientId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private PaymentDao dao;
@Lazy @Autowired private ClientService clientService;
}