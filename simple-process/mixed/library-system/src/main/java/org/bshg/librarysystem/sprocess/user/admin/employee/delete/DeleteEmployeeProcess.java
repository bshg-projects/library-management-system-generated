package org.bshg.librarysystem.sprocess.user.admin.employee.delete;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
import java.util.List;
public interface DeleteEmployeeProcess {
void run(Employee item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Employee> items);
void deleteByAddress(Address address);
}