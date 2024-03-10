package org.bshg.librarysystem.payment.services;

import org.bshg.librarysystem.payment.Payment;

import java.util.List;

public interface PaymentService {
    Payment findById(Long id);

    List<Payment> findAllOptimized();

    List<Payment> findAll();

    Payment create(Payment item);

    Payment edit(Payment item);

    void deleteById(Long id);

    void delete(Payment item);

    void delete(List<Payment> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByClientId(Long id);

    List<Payment> findByClientId(Long id);
}