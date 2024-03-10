package org.bshg.librarysystem.payment.services;

import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface PaymentService extends IService<Payment> {
    int deleteByClientId(Long id);

    List<Payment> findByClientId(Long id);
}