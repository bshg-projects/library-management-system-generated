package org.bshg.librarysystem.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionDao extends JpaRepository<Transaction, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByClientId(Long id);

    List<Transaction> findByClientId(Long id);

    @Query("SELECT NEW Transaction(item.id,item.name) FROM Transaction item")
    List<Transaction> findAllOptimized();
}