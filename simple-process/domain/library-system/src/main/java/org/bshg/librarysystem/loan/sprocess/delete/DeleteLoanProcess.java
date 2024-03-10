package org.bshg.librarysystem.loan.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.loan.Loan;

import java.util.List;

public interface DeleteLoanProcess {
    void run(Loan item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Loan> items);

    void deleteByBook(Book book);

    void deleteByClient(Client client);

    void deleteByEmployee(Employee employee);
}