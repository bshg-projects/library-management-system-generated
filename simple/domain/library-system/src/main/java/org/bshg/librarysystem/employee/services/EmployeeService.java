package org.bshg.librarysystem.employee.services;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.book.Book;
import java.util.List;
public interface EmployeeService {
Employee findById(Long id);
List<Employee> findAllOptimized();
List<Employee> findAll();
Employee create(Employee item);
List<Employee> create(List<Employee> item);
Employee update(Employee item);
List<Employee> update(List<Employee> item);
void deleteById(Long id);
void delete(Employee item);
void delete(List<Employee> items);
void deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Employee findByAddressId(Long id);
}