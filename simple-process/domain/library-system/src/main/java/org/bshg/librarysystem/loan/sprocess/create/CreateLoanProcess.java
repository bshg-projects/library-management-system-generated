package org.bshg.librarysystem.loan.sprocess.create;
import org.bshg.librarysystem.loan.Loan;
import java.util.List;
public interface CreateLoanProcess {
Loan run(Loan item);
List<Loan> run(List<Loan> items);
}