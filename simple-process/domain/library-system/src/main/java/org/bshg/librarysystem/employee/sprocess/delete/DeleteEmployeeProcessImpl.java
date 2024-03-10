package org.bshg.librarysystem.employee.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteEmployeeProcessImpl implements DeleteEmployeeProcess {
    private void process(Employee item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Employee item) {
        process(item);
        deleteAssociated(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Employee item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Employee item = service.findById(id);
            if (item != null) {
                process(item);
                deleteAssociated(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Employee> items) {
        items.forEach(this::process);
        items.forEach(this::deleteAssociated);
        service.delete(items);
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

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociated(Employee item) {
        if (item == null || item.getId() == null) return;
        deleteAssociatedList(item);
    }

    private void deleteAssociatedList(Employee item) {
        deleteBookProcess.deleteByEmployee(item);
        deleteLoanProcess.deleteByEmployee(item);
        deleteEmployeeAssignmentProcess.deleteByEmployee(item);
    }

    @Autowired
    private EmployeeService service;
    @Autowired
    @Lazy
    private AddressService addressService;
    @Autowired
    @Lazy
    private LoanService loanService;
    @Autowired
    @Lazy
    private EmployeeAssignmentService employeeAssignmentService;
    @Autowired
    @Lazy
    private BookService bookService;
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