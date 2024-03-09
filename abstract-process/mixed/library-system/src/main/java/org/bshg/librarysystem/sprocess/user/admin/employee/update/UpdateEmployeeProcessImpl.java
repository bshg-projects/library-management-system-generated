package org.bshg.librarysystem.sprocess.user.admin.employee.update;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateEmployeeProcessImpl extends AbstractUpdateProcessImpl<Employee, EmployeeService> implements UpdateEmployeeProcess {
public UpdateEmployeeProcessImpl(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
super(service);
this.addressService = addressService;
this.loanService = loanService;
this.employeeAssignmentService = employeeAssignmentService;
this.bookService = bookService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Employee run(Employee item) {
// Your Update Logic For 'Employee'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Employee item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
bookService::findByEmployeeId,
Employee::getBooks,
Book::setEmployee,
updateBookProcess,
deleteBookProcess
);
ProcessHelper.updateList(
item,
loanService::findByEmployeeId,
Employee::getLoans,
Loan::setEmployee,
updateLoanProcess,
deleteLoanProcess
);
ProcessHelper.updateList(
item,
employeeAssignmentService::findByEmployeeId,
Employee::getEmployeeAssignment,
EmployeeAssignment::setEmployee,
updateEmployeeAssignmentProcess,
deleteEmployeeAssignmentProcess
);
}
private AddressService addressService;
private UpdateAddressProcess updateAddressProcess;
private DeleteAddressProcess deleteAddressProcess;
public void setUpdateAddressProcess(UpdateAddressProcess value) {
this.updateAddressProcess = value;
}
public void setDeleteAddressProcess(DeleteAddressProcess value) {
this.deleteAddressProcess = value;
}
private LoanService loanService;
private UpdateLoanProcess updateLoanProcess;
private DeleteLoanProcess deleteLoanProcess;
public void setUpdateLoanProcess(UpdateLoanProcess value) {
this.updateLoanProcess = value;
}
public void setDeleteLoanProcess(DeleteLoanProcess value) {
this.deleteLoanProcess = value;
}
private EmployeeAssignmentService employeeAssignmentService;
private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
public void setUpdateEmployeeAssignmentProcess(UpdateEmployeeAssignmentProcess value) {
this.updateEmployeeAssignmentProcess = value;
}
public void setDeleteEmployeeAssignmentProcess(DeleteEmployeeAssignmentProcess value) {
this.deleteEmployeeAssignmentProcess = value;
}
private BookService bookService;
private UpdateBookProcess updateBookProcess;
private DeleteBookProcess deleteBookProcess;
public void setUpdateBookProcess(UpdateBookProcess value) {
this.updateBookProcess = value;
}
public void setDeleteBookProcess(DeleteBookProcess value) {
this.deleteBookProcess = value;
}
}