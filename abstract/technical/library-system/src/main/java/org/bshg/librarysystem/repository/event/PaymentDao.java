package org.bshg.librarysystem.repository.event;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface PaymentDao extends Repository<Payment, Long> {
int deleteByClientId(Long id);
List<Payment> findByClientId(Long id);
@Query("SELECT NEW Payment(item.id,item.name) FROM Payment item")
List<Payment> findAllOptimized();
}