package org.bshg.librarysystem.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanDao extends JpaRepository<Loan, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByBookId(Long id);

    Loan findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Loan> findByClientId(Long id);

    int deleteByEmployeeId(Long id);

    List<Loan> findByEmployeeId(Long id);

    @Query("SELECT NEW Loan(item.id,item.name) FROM Loan item")
    List<Loan> findAllOptimized();
}