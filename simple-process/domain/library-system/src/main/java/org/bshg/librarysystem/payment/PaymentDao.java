package org.bshg.librarysystem.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByClientId(Long id);

    List<Payment> findByClientId(Long id);

    @Query("SELECT NEW Payment(item.id,item.name) FROM Payment item")
    List<Payment> findAllOptimized();
}