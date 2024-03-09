package org.bshg.librarysystem.employee.services;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface EmployeeService extends IService<Employee> {
int deleteByAddressId(Long id);
Employee findByAddressId(Long id);
}