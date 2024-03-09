package org.bshg.librarysystem.sprocess.library.loan;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.impl.CreateLoanProcessImpl;
import org.bshg.librarysystem.sprocess.library.loan.impl.UpdateLoanProcessImpl;
import org.bshg.librarysystem.sprocess.library.loan.impl.DeleteLoanProcessImpl;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.UpdateEmployeeProcess;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Loan Processes (Create, Update, Delete).
*/
@Configuration
public class LoanInjector {
@Bean
public CreateLoanProcess createLoanProcess (LoanService service,EmployeeService employeeService,BookService bookService,ClientService clientService) {
var bean = new CreateLoanProcessImpl(service, employeeService, bookService, clientService);
bean.setCreateEmployeeProcess(this.createEmployeeProcess);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateClientProcess(this.createClientProcess);
return bean;
}
@Bean
public UpdateLoanProcess updateLoanProcess (LoanService service,EmployeeService employeeService,BookService bookService,ClientService clientService) {
var bean = new UpdateLoanProcessImpl(service,employeeService,bookService,clientService);
bean.setUpdateEmployeeProcess(this.updateEmployeeProcess);
bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateClientProcess(this.updateClientProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
return bean;
}
@Bean
public DeleteLoanProcess deleteLoanProcess(LoanService service,EmployeeService employeeService,BookService bookService,ClientService clientService) {
var bean = new DeleteLoanProcessImpl(service,employeeService,bookService,clientService);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteClientProcess(this.deleteClientProcess);
bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
return bean;
}
@Autowired @Lazy private CreateEmployeeProcess createEmployeeProcess;
@Autowired @Lazy private UpdateEmployeeProcess updateEmployeeProcess;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateClientProcess createClientProcess;
@Autowired @Lazy private UpdateClientProcess updateClientProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
}