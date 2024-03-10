package org.bshg.librarysystem.transaction.services;

import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface TransactionService extends IService<Transaction> {
    int deleteByClientId(Long id);

    List<Transaction> findByClientId(Long id);
}