package org.bshg.librarysystem.services.facade.library;

import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface LoanService {
    Loan findById(Long id);

    List<Loan> findAllOptimized();

    List<Loan> findAll();

    Loan create(Loan item);

    Loan edit(Loan item);

    void deleteById(Long id);

    void delete(Loan item);

    void delete(List<Loan> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByBookId(Long id);

    Loan findByBookId(Long id);

    int deleteByClientId(Long id);

    List<Loan> findByClientId(Long id);

    int deleteByEmployeeId(Long id);

    List<Loan> findByEmployeeId(Long id);
}