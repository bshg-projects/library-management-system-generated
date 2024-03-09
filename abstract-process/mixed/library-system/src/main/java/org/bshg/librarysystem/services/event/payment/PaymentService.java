package org.bshg.librarysystem.services.event.payment;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface PaymentService extends IService<Payment> {
int deleteByClientId(Long id);
List<Payment> findByClientId(Long id);
}