
package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.impl;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteEmployeeAssignmentProcessImpl extends AbstractDeleteProcessImpl<EmployeeAssignment, EmployeeAssignmentService> implements DeleteEmployeeAssignmentProcess {
public DeleteEmployeeAssignmentProcessImpl(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
super(service);
this.employeeService = employeeService;
this.adminService = adminService;
}
@Override
protected void process(EmployeeAssignment item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
public void deleteByAdmin(Admin admin) {
if (admin != null && admin.getId() != null){
service.deleteByAdminId(admin.getId());
}
}
public void deleteByEmployee(Employee employee) {
if (employee != null && employee.getId() != null){
service.deleteByEmployeeId(employee.getId());
}
}
private EmployeeService employeeService;
private AdminService adminService;
private DeleteAdminProcess deleteAdminProcess;
public void setDeleteAdminProcess(DeleteAdminProcess value) {
this.deleteAdminProcess = value;
}
private DeleteEmployeeProcess deleteEmployeeProcess;
public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
this.deleteEmployeeProcess = value;
}
}