package org.bshg.librarysystem.sprocess.user.admin.employee.delete;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
public interface DeleteEmployeeProcess extends IDeleteProcess<Employee> {
void deleteByAddress(Address address);
}