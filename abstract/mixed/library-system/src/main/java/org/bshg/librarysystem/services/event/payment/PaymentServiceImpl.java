
package org.bshg.librarysystem.services.event.payment;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.repository.event.PaymentDao;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
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