package org.bshg.librarysystem.employee.sprocess.delete;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.book.Book;
public interface DeleteEmployeeProcess extends IDeleteProcess<Employee> {
void deleteByAddress(Address address);
}