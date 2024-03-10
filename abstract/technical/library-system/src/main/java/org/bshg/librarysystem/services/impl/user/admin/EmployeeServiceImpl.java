package org.bshg.librarysystem.services.impl.user.admin;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.repository.user.admin.EmployeeDao;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl extends ServiceImpl<Employee, EmployeeDao> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeDao dao) {
        super(dao);
    }

    @Override
    public void deleteAssociatedList(Employee item) {
        if (item == null || item.getId() == null) return;
        bookService.deleteByEmployeeId(item.getId());
        loanService.deleteByEmployeeId(item.getId());
        employeeAssignmentService.deleteByEmployeeId(item.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAddressId(Long id) {
        Employee found = findByAddressId(id);
        if (found == null) return 0;
        this.deleteAssociated(found);
        return dao.deleteByAddressId(id);
    }

    @Override
    public Employee findByAddressId(Long id) {
        return dao.findByAddressId(id);
    }

    @Override
    public void createAssociatedList(Employee item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Employee::getBooks, Book::setEmployee, bookService);
        ServiceHelper.createList(item, Employee::getLoans, Loan::setEmployee, loanService);
        ServiceHelper.createList(item, Employee::getEmployeeAssignment, EmployeeAssignment::setEmployee, employeeAssignmentService);
    }

    @Override
    public void updateAssociatedList(Employee item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(item, bookService::findByEmployeeId, Employee::getBooks, Book::setEmployee, bookService);
        ServiceHelper.updateList(item, loanService::findByEmployeeId, Employee::getLoans, Loan::setEmployee, loanService);
        ServiceHelper.updateList(item, employeeAssignmentService::findByEmployeeId, Employee::getEmployeeAssignment, EmployeeAssignment::setEmployee, employeeAssignmentService);
    }

    @Lazy
    @Autowired
    private AddressService addressService;
    @Lazy
    @Autowired
    private BookService bookService;
    @Lazy
    @Autowired
    private LoanService loanService;
    @Lazy
    @Autowired
    private EmployeeAssignmentService employeeAssignmentService;
}