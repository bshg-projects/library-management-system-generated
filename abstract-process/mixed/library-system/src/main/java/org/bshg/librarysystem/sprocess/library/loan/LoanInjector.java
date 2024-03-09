package org.bshg.librarysystem.sprocess.library.loan;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcessImpl;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcessImpl;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcessImpl;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
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