package org.bshg.librarysystem.loan.services;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.client.Client;
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