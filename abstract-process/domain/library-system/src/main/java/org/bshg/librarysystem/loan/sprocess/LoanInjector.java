package org.bshg.librarysystem.loan.sprocess;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcessImpl;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcessImpl;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcessImpl;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
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