package org.bshg.librarysystem.loan.sprocess.update;

import org.bshg.librarysystem.loan.Loan;

import java.util.List;

public interface UpdateLoanProcess {
    Loan run(Loan item);

    List<Loan> run(List<Loan> items);
}
