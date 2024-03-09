
package org.bshg.librarysystem.employeeassignment.sprocess.delete;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
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