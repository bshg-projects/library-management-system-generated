package org.bshg.librarysystem.employee.sprocess.create;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
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