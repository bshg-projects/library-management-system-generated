package org.bshg.librarysystem.sprocess.library.loan.delete;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
public interface DeleteLoanProcess extends IDeleteProcess<Loan> {
void deleteByBook(Book book);
void deleteByClient(Client client);
void deleteByEmployee(Employee employee);
}