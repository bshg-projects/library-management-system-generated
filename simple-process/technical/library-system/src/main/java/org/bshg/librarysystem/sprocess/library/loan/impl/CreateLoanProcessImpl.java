package org.bshg.librarysystem.sprocess.library.loan.impl;

import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateLoanProcessImpl implements CreateLoanProcess {
    @Transactional(rollbackFor = Exception.class)
    public Loan run(Loan item) {
// Your Creation Logic For 'Loan'
        item = service.create(item);
        return item;
    }

    public List<Loan> run(List<Loan> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private LoanService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    @Lazy
    private CreateEmployeeProcess createEmployeeProcess;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private ClientService clientService;
    @Autowired
    @Lazy
    private CreateClientProcess createClientProcess;
}