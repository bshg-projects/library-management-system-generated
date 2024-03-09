package org.bshg.librarysystem.sprocess.user.admin.employee.impl;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateEmployeeProcessImpl implements CreateEmployeeProcess {
@Transactional(rollbackFor = Exception.class)
public Employee run(Employee item) {
// Your Creation Logic For 'Employee'
item = service.create(item);
createAssociatedList(item);
return item;
}
public List<Employee> run(List<Employee> items) {
items.forEach(this::run);
return items;
}
public void createAssociatedList(Employee item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Employee::getBooks, Book::setEmployee, createBookProcess::run);
ProcessHelper.createList(item, Employee::getLoans, Loan::setEmployee, createLoanProcess::run);
ProcessHelper.createList(item, Employee::getEmployeeAssignment, EmployeeAssignment::setEmployee, createEmployeeAssignmentProcess::run);
}
@Autowired private EmployeeService service;
@Autowired private AddressService addressService;
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
@Autowired private LoanService loanService;
@Autowired @Lazy private CreateLoanProcess createLoanProcess;
@Autowired private EmployeeAssignmentService employeeAssignmentService;
@Autowired @Lazy private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
@Autowired private BookService bookService;
@Autowired @Lazy private CreateBookProcess createBookProcess;
}