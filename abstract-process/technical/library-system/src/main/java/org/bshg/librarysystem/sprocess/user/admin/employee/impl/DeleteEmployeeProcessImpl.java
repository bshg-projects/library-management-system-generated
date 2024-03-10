package org.bshg.librarysystem.sprocess.user.admin.employee.impl;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class DeleteEmployeeProcessImpl extends AbstractDeleteProcessImpl<Employee, EmployeeService> implements DeleteEmployeeProcess {
    public DeleteEmployeeProcessImpl(EmployeeService service, AddressService addressService, LoanService loanService, EmployeeAssignmentService employeeAssignmentService, BookService bookService) {
        super(service);
        this.addressService = addressService;
        this.loanService = loanService;
        this.employeeAssignmentService = employeeAssignmentService;
        this.bookService = bookService;
    }

    @Override
    protected void process(Employee item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByAddress(Address address) {
        if (address != null && address.getId() != null) {
            Employee found = this.service.findByAddressId(address.getId());
            if (found == null) return;
            this.deleteAssociated(found);
            service.deleteByAddressId(address.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Employee item) {
        deleteBookProcess.deleteByEmployee(item);
        deleteLoanProcess.deleteByEmployee(item);
        deleteEmployeeAssignmentProcess.deleteByEmployee(item);
    }

    private AddressService addressService;
    private LoanService loanService;
    private EmployeeAssignmentService employeeAssignmentService;
    private BookService bookService;
    private DeleteAddressProcess deleteAddressProcess;

    public void setDeleteAddressProcess(DeleteAddressProcess value) {
        this.deleteAddressProcess = value;
    }

    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteLoanProcess deleteLoanProcess;

    public void setDeleteLoanProcess(DeleteLoanProcess value) {
        this.deleteLoanProcess = value;
    }

    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;

    public void setDeleteEmployeeAssignmentProcess(DeleteEmployeeAssignmentProcess value) {
        this.deleteEmployeeAssignmentProcess = value;
    }
}