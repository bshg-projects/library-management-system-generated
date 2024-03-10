package org.bshg.librarysystem.sprocess.user.admin.employee;

import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.impl.CreateEmployeeProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employee.impl.DeleteEmployeeProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employee.impl.UpdateEmployeeProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.UpdateEmployeeAssignmentProcess;
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