package org.bshg.librarysystem.services.facade.event;

import org.bshg.librarysystem.entity.core.event.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction findById(Long id);

    List<Transaction> findAllOptimized();

    List<Transaction> findAll();

    Transaction create(Transaction item);

    List<Transaction> create(List<Transaction> item);

    Transaction update(Transaction item);

    List<Transaction> update(List<Transaction> item);

    void deleteById(Long id);

    void delete(Transaction item);

    void delete(List<Transaction> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByClientId(Long id);

    List<Transaction> findByClientId(Long id);
}