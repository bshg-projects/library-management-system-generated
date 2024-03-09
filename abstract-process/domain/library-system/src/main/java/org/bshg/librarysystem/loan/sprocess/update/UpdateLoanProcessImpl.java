package org.bshg.librarysystem.loan.sprocess.update;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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