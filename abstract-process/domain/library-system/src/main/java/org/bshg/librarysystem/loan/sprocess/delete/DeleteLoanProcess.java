package org.bshg.librarysystem.loan.sprocess.delete;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
public interface DeleteLoanProcess extends IDeleteProcess<Loan> {
void deleteByBook(Book book);
void deleteByClient(Client client);
void deleteByEmployee(Employee employee);
}