package org.bshg.librarysystem.sprocess.user.admin.employee.create;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateEmployeeProcessImpl extends AbstractCreateProcessImpl<Employee, EmployeeService> implements CreateEmployeeProcess {
public CreateEmployeeProcessImpl(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
super(service);
this.addressService = addressService;
this.loanService = loanService;
this.employeeAssignmentService = employeeAssignmentService;
this.bookService = bookService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Employee run(Employee item) {
// Your Insert Logic For 'Employee'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Employee item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Employee::getBooks, Book::setEmployee, createBookProcess);
ProcessHelper.createList(item, Employee::getLoans, Loan::setEmployee, createLoanProcess);
ProcessHelper.createList(item, Employee::getEmployeeAssignment, EmployeeAssignment::setEmployee, createEmployeeAssignmentProcess);
}
private AddressService addressService;
private CreateAddressProcess createAddressProcess;
public void setCreateAddressProcess(CreateAddressProcess value) {
this.createAddressProcess = value;
}
private LoanService loanService;
private CreateLoanProcess createLoanProcess;
public void setCreateLoanProcess(CreateLoanProcess value) {
this.createLoanProcess = value;
}
private EmployeeAssignmentService employeeAssignmentService;
private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
public void setCreateEmployeeAssignmentProcess(CreateEmployeeAssignmentProcess value) {
this.createEmployeeAssignmentProcess = value;
}
private BookService bookService;
private CreateBookProcess createBookProcess;
public void setCreateBookProcess(CreateBookProcess value) {
this.createBookProcess = value;
}
}