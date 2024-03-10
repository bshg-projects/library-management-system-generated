package org.bshg.librarysystem.sprocess.library.loan.impl;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class DeleteLoanProcessImpl extends AbstractDeleteProcessImpl<Loan, LoanService> implements DeleteLoanProcess {
    public DeleteLoanProcessImpl(LoanService service, EmployeeService employeeService, BookService bookService, ClientService clientService) {
        super(service);
        this.employeeService = employeeService;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @Override
    protected void process(Loan item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByBook(Book book) {
        if (book != null && book.getId() != null) {
            service.deleteByBookId(book.getId());
        }
    }

    public void deleteByClient(Client client) {
        if (client != null && client.getId() != null) {
            service.deleteByClientId(client.getId());
        }
    }

    public void deleteByEmployee(Employee employee) {
        if (employee != null && employee.getId() != null) {
            service.deleteByEmployeeId(employee.getId());
        }
    }

    private EmployeeService employeeService;
    private BookService bookService;
    private ClientService clientService;
    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteClientProcess deleteClientProcess;

    public void setDeleteClientProcess(DeleteClientProcess value) {
        this.deleteClientProcess = value;
    }

    private DeleteEmployeeProcess deleteEmployeeProcess;

    public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
        this.deleteEmployeeProcess = value;
    }
}