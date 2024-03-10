package org.bshg.librarysystem.loan.sprocess.create;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateLoanProcessImpl extends AbstractCreateProcessImpl<Loan, LoanService> implements CreateLoanProcess {
    public CreateLoanProcessImpl(LoanService service, EmployeeService employeeService, BookService bookService, ClientService clientService) {
        super(service);
        this.employeeService = employeeService;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Loan run(Loan item) {
// Your Insert Logic For 'Loan'
        item = service.create(item);
        return item;
    }

    private EmployeeService employeeService;
    private CreateEmployeeProcess createEmployeeProcess;

    public void setCreateEmployeeProcess(CreateEmployeeProcess value) {
        this.createEmployeeProcess = value;
    }

    private BookService bookService;
    private CreateBookProcess createBookProcess;

    public void setCreateBookProcess(CreateBookProcess value) {
        this.createBookProcess = value;
    }

    private ClientService clientService;
    private CreateClientProcess createClientProcess;

    public void setCreateClientProcess(CreateClientProcess value) {
        this.createClientProcess = value;
    }
}