package org.bshg.librarysystem.sprocess.user.admin.employee.update;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update.UpdateEmployeeAssignmentProcess;
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