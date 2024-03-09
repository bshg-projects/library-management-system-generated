
package org.bshg.librarysystem.admin.sprocess.delete;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcess;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteAdminProcessImpl extends AbstractDeleteProcessImpl<Admin, AdminService> implements DeleteAdminProcess {
public DeleteAdminProcessImpl(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
super(service);
this.employeeAssignmentService = employeeAssignmentService;
}
@Override
protected void process(Admin item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Override
public void deleteAssociatedList(Admin item) {
deleteEmployeeAssignmentProcess.deleteByAdmin(item);
}
private EmployeeAssignmentService employeeAssignmentService;
private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
public void setDeleteEmployeeAssignmentProcess(DeleteEmployeeAssignmentProcess value) {
this.deleteEmployeeAssignmentProcess = value;
}
}