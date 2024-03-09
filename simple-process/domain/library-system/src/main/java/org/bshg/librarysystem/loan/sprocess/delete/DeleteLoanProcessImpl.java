
package org.bshg.librarysystem.loan.sprocess.delete;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteLoanProcessImpl implements DeleteLoanProcess {
private void process(Loan item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Loan item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Loan item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Loan item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Loan> items) {
items.forEach(this::process);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByBook(Book book) {
if (book != null && book.getId() != null){
service.deleteByBookId(book.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByClient(Client client) {
if (client != null && client.getId() != null){
service.deleteByClientId(client.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByEmployee(Employee employee) {
if (employee != null && employee.getId() != null){
service.deleteByEmployeeId(employee.getId());
}
}
@Autowired private LoanService service;
@Autowired @Lazy private EmployeeService employeeService;
@Autowired @Lazy private BookService bookService;
@Autowired @Lazy private ClientService clientService;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteClientProcess deleteClientProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
}