
package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.delete.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteEmployeeAssignmentProcessImpl implements DeleteEmployeeAssignmentProcess {
private void process(EmployeeAssignment item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(EmployeeAssignment item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
EmployeeAssignment item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
EmployeeAssignment item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<EmployeeAssignment> items) {
items.forEach(this::process);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByAdmin(Admin admin) {
if (admin != null && admin.getId() != null){
service.deleteByAdminId(admin.getId());
}
}
@Transactional(rollbackFor = Exception.class)
public void deleteByEmployee(Employee employee) {
if (employee != null && employee.getId() != null){
service.deleteByEmployeeId(employee.getId());
}
}
@Autowired private EmployeeAssignmentService service;
@Autowired @Lazy private EmployeeService employeeService;
@Autowired @Lazy private AdminService adminService;
@Autowired @Lazy private DeleteAdminProcess deleteAdminProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
}