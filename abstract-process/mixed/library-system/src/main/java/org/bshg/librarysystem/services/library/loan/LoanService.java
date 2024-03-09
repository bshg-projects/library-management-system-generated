package org.bshg.librarysystem.services.library.loan;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface LoanService extends IService<Loan> {
int deleteByBookId(Long id);
Loan findByBookId(Long id);
int deleteByClientId(Long id);
List<Loan> findByClientId(Long id);
int deleteByEmployeeId(Long id);
List<Loan> findByEmployeeId(Long id);
}