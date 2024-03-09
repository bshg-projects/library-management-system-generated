package org.bshg.librarysystem.employee;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeeDao extends Repository<Employee, Long> {
int deleteByAddressId(Long id);
Employee findByAddressId(Long id);
}