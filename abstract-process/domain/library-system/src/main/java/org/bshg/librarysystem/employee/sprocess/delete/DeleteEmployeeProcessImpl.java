
package org.bshg.librarysystem.employee.sprocess.delete;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteEmployeeProcessImpl extends AbstractDeleteProcessImpl<Employee, EmployeeService> implements DeleteEmployeeProcess {
public DeleteEmployeeProcessImpl(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
super(service);
this.addressService = addressService;
this.loanService = loanService;
this.employeeAssignmentService = employeeAssignmentService;
this.bookService = bookService;
}
@Override
protected void process(Employee item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void deleteByAddress(Address address) {
if (address != null && address.getId() != null){
Employee found = this.service.findByAddressId(address.getId());
if (found == null) return;
this.deleteAssociated(found);
service.deleteByAddressId(address.getId());
}
}
@Override
public void deleteAssociatedList(Employee item) {
deleteBookProcess.deleteByEmployee(item);
deleteLoanProcess.deleteByEmployee(item);
deleteEmployeeAssignmentProcess.deleteByEmployee(item);
}
private AddressService addressService;
private LoanService loanService;
private EmployeeAssignmentService employeeAssignmentService;
private BookService bookService;
private DeleteAddressProcess deleteAddressProcess;
public void setDeleteAddressProcess(DeleteAddressProcess value) {
this.deleteAddressProcess = value;
}
private DeleteBookProcess deleteBookProcess;
public void setDeleteBookProcess(DeleteBookProcess value) {
this.deleteBookProcess = value;
}
private DeleteLoanProcess deleteLoanProcess;
public void setDeleteLoanProcess(DeleteLoanProcess value) {
this.deleteLoanProcess = value;
}
private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
public void setDeleteEmployeeAssignmentProcess(DeleteEmployeeAssignmentProcess value) {
this.deleteEmployeeAssignmentProcess = value;
}
}