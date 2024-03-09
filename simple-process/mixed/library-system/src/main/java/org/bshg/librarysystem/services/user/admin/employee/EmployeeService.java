package org.bshg.librarysystem.services.user.admin.employee;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
import java.util.List;
public interface EmployeeService {
Employee findById(Long id);
List<Employee> findAllOptimized();
List<Employee> findAll();
Employee create(Employee item);
Employee edit(Employee item);
void deleteById(Long id);
void delete(Employee item);
void delete(List<Employee> items);
void deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Employee findByAddressId(Long id);
}