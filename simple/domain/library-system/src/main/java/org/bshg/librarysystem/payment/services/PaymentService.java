package org.bshg.librarysystem.payment.services;

import org.bshg.librarysystem.payment.Payment;

import java.util.List;

public interface PaymentService {
    Payment findById(Long id);

    List<Payment> findAllOptimized();

    List<Payment> findAll();

    Payment create(Payment item);

    List<Payment> create(List<Payment> item);

    Payment update(Payment item);

    List<Payment> update(List<Payment> item);

    void deleteById(Long id);

    void delete(Payment item);

    void delete(List<Payment> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByClientId(Long id);

    List<Payment> findByClientId(Long id);
}