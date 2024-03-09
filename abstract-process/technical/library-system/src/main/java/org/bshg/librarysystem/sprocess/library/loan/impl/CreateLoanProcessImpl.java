package org.bshg.librarysystem.sprocess.library.loan.impl;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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