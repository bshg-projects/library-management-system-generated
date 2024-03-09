package org.bshg.librarysystem.sprocess.library.loan.create;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private LoanService service;
@Autowired private EmployeeService employeeService;
@Autowired @Lazy private CreateEmployeeProcess createEmployeeProcess;
@Autowired private BookService bookService;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired private ClientService clientService;
@Autowired @Lazy private CreateClientProcess createClientProcess;
}