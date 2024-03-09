package org.bshg.librarysystem.employee.sprocess.create;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.book.Book;
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