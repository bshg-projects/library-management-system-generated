package org.bshg.librarysystem.repository.library;

import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanDao extends Repository<Loan, Long> {
    int deleteByBookId(Long id);

    Loan findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Loan> findByClientId(Long id);

    int deleteByEmployeeId(Long id);

    List<Loan> findByEmployeeId(Long id);

    @Query("SELECT NEW Loan(item.id,item.name) FROM Loan item")
    List<Loan> findAllOptimized();
}