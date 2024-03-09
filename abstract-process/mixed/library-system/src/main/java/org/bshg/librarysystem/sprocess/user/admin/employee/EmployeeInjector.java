package org.bshg.librarysystem.sprocess.user.admin.employee;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcessImpl;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcess;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Employee Processes (Create, Update, Delete).
*/
@Configuration
public class EmployeeInjector {
@Bean
public CreateEmployeeProcess createEmployeeProcess (EmployeeService service,AddressService addressService,LoanService loanService,EmployeeAssignmentService employeeAssignmentService,BookService bookService) {
var bean = new CreateEmployeeProcessImpl(service, addressService, loanService, employeeAssignmentService, bookService);
bean.setCreateAddressProcess(this.createAddressProcess);
bean.setCreateLoanProcess(this.createLoanProcess);
bean.setCreateEmployeeAssignmentProcess(this.createEmployeeAssignmentProcess);
bean.setCreateBookProcess(this.createBookProcess);
return bean;
}
@Bean
public UpdateEmployeeProcess updateEmployeeProcess (EmployeeService service,AddressService addressService,LoanService loanService,EmployeeAssignmentService employeeAssignmentService,BookService bookService) {
var bean = new UpdateEmployeeProcessImpl(service,addressService,loanService,employeeAssignmentService,bookService);
bean.setUpdateAddressProcess(this.updateAddressProcess);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
bean.setUpdateLoanProcess(this.updateLoanProcess);
bean.setDeleteLoanProcess(this.deleteLoanProcess);
bean.setUpdateEmployeeAssignmentProcess(this.updateEmployeeAssignmentProcess);
bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
return bean;
}
@Bean
public DeleteEmployeeProcess deleteEmployeeProcess(EmployeeService service,AddressService addressService,LoanService loanService,EmployeeAssignmentService employeeAssignmentService,BookService bookService) {
var bean = new DeleteEmployeeProcessImpl(service,addressService,loanService,employeeAssignmentService,bookService);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteLoanProcess(this.deleteLoanProcess);
bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
return bean;
}
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
@Autowired @Lazy private UpdateAddressProcess updateAddressProcess;
@Autowired @Lazy private CreateLoanProcess createLoanProcess;
@Autowired @Lazy private UpdateLoanProcess updateLoanProcess;
@Autowired @Lazy private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
@Autowired @Lazy private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired @Lazy private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}