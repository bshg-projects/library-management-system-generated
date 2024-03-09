
package org.bshg.librarysystem.sprocess.user.admin.employee.impl;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
if (address != null && address.getId() != null){
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
@Autowired private EmployeeService service;
@Autowired @Lazy private AddressService addressService;
@Autowired @Lazy private LoanService loanService;
@Autowired @Lazy private EmployeeAssignmentService employeeAssignmentService;
@Autowired @Lazy private BookService bookService;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired @Lazy private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}