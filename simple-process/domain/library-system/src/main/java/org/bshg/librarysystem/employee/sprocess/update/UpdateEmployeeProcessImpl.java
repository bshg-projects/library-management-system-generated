package org.bshg.librarysystem.employee.sprocess.update;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateEmployeeProcessImpl implements UpdateEmployeeProcess {
    @Transactional(rollbackFor = Exception.class)
    public Employee run(Employee item) { // Your Logic To Update 'Employee'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    public List<Employee> run(List<Employee> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(Employee item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                bookService.findByEmployeeId(item.getId()),
                item.getBooks(),
                Book::setEmployee,
                updateBookProcess::run,
                deleteBookProcess::run
        );
        ProcessHelper.updateList(
                item,
                loanService.findByEmployeeId(item.getId()),
                item.getLoans(),
                Loan::setEmployee,
                updateLoanProcess::run,
                deleteLoanProcess::run
        );
        ProcessHelper.updateList(
                item,
                employeeAssignmentService.findByEmployeeId(item.getId()),
                item.getEmployeeAssignment(),
                EmployeeAssignment::setEmployee,
                updateEmployeeAssignmentProcess::run,
                deleteEmployeeAssignmentProcess::run
        );
    }

    @Autowired
    private EmployeeService service;
    @Autowired
    BookService bookService;
    @Autowired
    @Lazy
    private UpdateBookProcess updateBookProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    LoanService loanService;
    @Autowired
    @Lazy
    private UpdateLoanProcess updateLoanProcess;
    @Autowired
    @Lazy
    private DeleteLoanProcess deleteLoanProcess;
    @Autowired
    EmployeeAssignmentService employeeAssignmentService;
    @Autowired
    @Lazy
    private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}