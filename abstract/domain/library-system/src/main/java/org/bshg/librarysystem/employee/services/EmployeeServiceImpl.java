
package org.bshg.librarysystem.employee.services;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.EmployeeDao;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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
public int deleteByAddressId(Long id){
Employee found = findByAddressId(id);
if (found == null) return 0;
this.deleteAssociated(found);
return dao.deleteByAddressId(id);
}
@Override
public Employee findByAddressId(Long id){
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
ServiceHelper.updateList(item,bookService::findByEmployeeId,Employee::getBooks,Book::setEmployee,bookService);
ServiceHelper.updateList(item,loanService::findByEmployeeId,Employee::getLoans,Loan::setEmployee,loanService);
ServiceHelper.updateList(item,employeeAssignmentService::findByEmployeeId,Employee::getEmployeeAssignment,EmployeeAssignment::setEmployee,employeeAssignmentService);
}
@Lazy @Autowired private AddressService addressService;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private LoanService loanService;
@Lazy @Autowired private EmployeeAssignmentService employeeAssignmentService;
}