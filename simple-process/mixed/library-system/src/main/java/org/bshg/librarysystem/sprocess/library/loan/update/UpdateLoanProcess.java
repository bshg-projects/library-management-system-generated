package org.bshg.librarysystem.sprocess.library.loan.update;

import org.bshg.librarysystem.entity.core.library.Loan;

import java.util.List;

public interface UpdateLoanProcess {
    Loan run(Loan item);

    List<Loan> run(List<Loan> items);
}
