package org.bshg.librarysystem.employee.sprocess;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcessImpl;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcessImpl;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcessImpl;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Employee Processes (Create, Update, Delete).
 */
@Configuration
public class EmployeeInjector {
    @Bean
    public CreateEmployeeProcess createEmployeeProcess(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
        var bean = new CreateEmployeeProcessImpl(service, addressService, loanService, employeeAssignmentService, bookService);
        bean.setCreateAddressProcess(this.createAddressProcess);
        bean.setCreateLoanProcess(this.createLoanProcess);
        bean.setCreateEmployeeAssignmentProcess(this.createEmployeeAssignmentProcess);
        bean.setCreateBookProcess(this.createBookProcess);
        return bean;
    }

    @Bean
    public UpdateEmployeeProcess updateEmployeeProcess(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
        var bean = new UpdateEmployeeProcessImpl(service, addressService, loanService, employeeAssignmentService, bookService);
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
    public DeleteEmployeeProcess deleteEmployeeProcess(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
        var bean = new DeleteEmployeeProcessImpl(service, addressService, loanService, employeeAssignmentService, bookService);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setDeleteLoanProcess(this.deleteLoanProcess);
        bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
    @Autowired
    @Lazy
    private UpdateAddressProcess updateAddressProcess;
    @Autowired
    @Lazy
    private CreateLoanProcess createLoanProcess;
    @Autowired
    @Lazy
    private UpdateLoanProcess updateLoanProcess;
    @Autowired
    @Lazy
    private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
    @Autowired
    @Lazy
    private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    @Lazy
    private UpdateBookProcess updateBookProcess;
    @Autowired
    @Lazy
    private DeleteAddressProcess deleteAddressProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteLoanProcess deleteLoanProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}