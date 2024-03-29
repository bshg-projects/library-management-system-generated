package org.bshg.librarysystem.services.facade.library;

import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface LoanService extends IService<Loan> {
    int deleteByBookId(Long id);

    Loan findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Loan> findByClientId(Long id);

    int deleteByEmployeeId(Long id);

    List<Loan> findByEmployeeId(Long id);
}