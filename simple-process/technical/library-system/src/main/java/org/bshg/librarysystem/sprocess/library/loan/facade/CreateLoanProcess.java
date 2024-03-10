package org.bshg.librarysystem.sprocess.library.loan.facade;

import org.bshg.librarysystem.entity.core.library.Loan;

import java.util.List;

public interface CreateLoanProcess {
    Loan run(Loan item);

    List<Loan> run(List<Loan> items);
}