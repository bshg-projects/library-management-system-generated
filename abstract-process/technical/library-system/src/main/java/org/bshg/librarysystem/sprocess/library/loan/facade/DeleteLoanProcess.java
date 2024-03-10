package org.bshg.librarysystem.sprocess.library.loan.facade;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteLoanProcess extends IDeleteProcess<Loan> {
    void deleteByBook(Book book);

    void deleteByClient(Client client);

    void deleteByEmployee(Employee employee);
}