package org.bshg.librarysystem.sprocess.user.admin.admin.impl;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.UpdateAdminProcess;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateAdminProcessImpl extends AbstractUpdateProcessImpl<Admin, AdminService> implements UpdateAdminProcess {
public UpdateAdminProcessImpl(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
super(service);
this.employeeAssignmentService = employeeAssignmentService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Admin run(Admin item) {
// Your Update Logic For 'Admin'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
employeeAssignmentService::findByAdminId,
Admin::getEmployeeAssignment,
EmployeeAssignment::setAdmin,
updateEmployeeAssignmentProcess,
deleteEmployeeAssignmentProcess
);
}
private EmployeeAssignmentService employeeAssignmentService;
private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
public void setUpdateEmployeeAssignmentProcess(UpdateEmployeeAssignmentProcess value) {
this.updateEmployeeAssignmentProcess = value;
}
public void setDeleteEmployeeAssignmentProcess(DeleteEmployeeAssignmentProcess value) {
this.deleteEmployeeAssignmentProcess = value;
}
}