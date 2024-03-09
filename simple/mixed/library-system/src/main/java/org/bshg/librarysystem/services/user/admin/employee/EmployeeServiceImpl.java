package org.bshg.librarysystem.services.user.admin.employee;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.repository.user.admin.EmployeeDao;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class EmployeeServiceImpl implements EmployeeService {
//--------------- FIND -------------------------------------
public Employee findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Employee> findAll() {
return dao.findAll();
}
public List<Employee> findAllOptimized() {
return findAll();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Employee create(Employee item) {
if (item == null) return null;
Employee saved = dao.save(item);
createAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Employee> create(List<Employee> items) {
List<Employee> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Employee update(Employee item) {
if (item == null || item.getId() == null) return null;
Employee saved = dao.save(item);
updateAssociatedList(saved);
return saved;
}
@Transactional(rollbackFor = Exception.class)
public List<Employee> update(List<Employee> items) {
List<Employee> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Employee item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Employee item) {
deleteAssociated(item);
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Employee> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
ids.forEach(id -> {
Employee item = findById(id);
if (item != null) {
deleteAssociated(item);
}
});
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
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
//----------------------------------------------------------
public void createAssociatedList(Employee item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Employee::getBooks, Book::setEmployee, bookService::create);
ServiceHelper.createList(item, Employee::getLoans, Loan::setEmployee, loanService::create);
ServiceHelper.createList(item, Employee::getEmployeeAssignment, EmployeeAssignment::setEmployee, employeeAssignmentService::create);
}
public void updateAssociatedList(Employee item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(
item, bookService.findByEmployeeId(item.getId()),
item.getBooks(), Book::setEmployee,
bookService::update,
bookService::delete
);
ServiceHelper.updateList(
item, loanService.findByEmployeeId(item.getId()),
item.getLoans(), Loan::setEmployee,
loanService::update,
loanService::delete
);
ServiceHelper.updateList(
item, employeeAssignmentService.findByEmployeeId(item.getId()),
item.getEmployeeAssignment(), EmployeeAssignment::setEmployee,
employeeAssignmentService::update,
employeeAssignmentService::delete
);
}
@Transactional(rollbackFor = Exception.class)
public void deleteAssociated(Employee item) {
deleteAssociatedList(item);
}
public void deleteAssociatedList(Employee item) {
bookService.deleteByEmployeeId(item.getId());
loanService.deleteByEmployeeId(item.getId());
employeeAssignmentService.deleteByEmployeeId(item.getId());
}
//----------------------------------------------------------
@Autowired private EmployeeDao dao;
@Lazy @Autowired private AddressService addressService;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private LoanService loanService;
@Lazy @Autowired private EmployeeAssignmentService employeeAssignmentService;
}