package org.bshg.librarysystem.sprocess.library.loan.facade;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
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