package org.bshg.librarysystem.sprocess.library.loan.update;

import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateLoanProcessImpl extends AbstractUpdateProcessImpl<Loan, LoanService> implements UpdateLoanProcess {
    public UpdateLoanProcessImpl(LoanService service, EmployeeService employeeService, BookService bookService, ClientService clientService) {
        super(service);
        this.employeeService = employeeService;
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Loan run(Loan item) {
// Your Update Logic For 'Loan'
        item = service.edit(item);
        return item;
    }

    private EmployeeService employeeService;
    private UpdateEmployeeProcess updateEmployeeProcess;
    private DeleteEmployeeProcess deleteEmployeeProcess;

    public void setUpdateEmployeeProcess(UpdateEmployeeProcess value) {
        this.updateEmployeeProcess = value;
    }

    public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
        this.deleteEmployeeProcess = value;
    }

    private BookService bookService;
    private UpdateBookProcess updateBookProcess;
    private DeleteBookProcess deleteBookProcess;

    public void setUpdateBookProcess(UpdateBookProcess value) {
        this.updateBookProcess = value;
    }

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private ClientService clientService;
    private UpdateClientProcess updateClientProcess;
    private DeleteClientProcess deleteClientProcess;

    public void setUpdateClientProcess(UpdateClientProcess value) {
        this.updateClientProcess = value;
    }

    public void setDeleteClientProcess(DeleteClientProcess value) {
        this.deleteClientProcess = value;
    }
}