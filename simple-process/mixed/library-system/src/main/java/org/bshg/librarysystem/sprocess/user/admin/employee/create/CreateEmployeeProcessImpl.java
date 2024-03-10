package org.bshg.librarysystem.sprocess.user.admin.employee.create;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private EmployeeService service;
    @Autowired
    private AddressService addressService;
    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
    @Autowired
    private LoanService loanService;
    @Autowired
    @Lazy
    private CreateLoanProcess createLoanProcess;
    @Autowired
    private EmployeeAssignmentService employeeAssignmentService;
    @Autowired
    @Lazy
    private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
}