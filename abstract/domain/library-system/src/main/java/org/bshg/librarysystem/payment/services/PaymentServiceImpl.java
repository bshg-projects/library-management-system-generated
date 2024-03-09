
package org.bshg.librarysystem.payment.services;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.PaymentDao;
import org.bshg.librarysystem.payment.services.PaymentService;
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
public class PaymentServiceImpl extends ServiceImpl<Payment, PaymentDao> implements PaymentService {
public PaymentServiceImpl(PaymentDao dao) {
super(dao);
}
@Override
public List<Payment> findAllOptimized() {
return dao.findAllOptimized();
}
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
@Lazy @Autowired private ClientService clientService;
}