package org.bshg.librarysystem.sprocess.user.admin.admin.impl;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.CreateAdminProcess;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateAdminProcessImpl extends AbstractCreateProcessImpl<Admin, AdminService> implements CreateAdminProcess {
public CreateAdminProcessImpl(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
super(service);
this.employeeAssignmentService = employeeAssignmentService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Admin run(Admin item) {
// Your Insert Logic For 'Admin'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Admin::getEmployeeAssignment, EmployeeAssignment::setAdmin, createEmployeeAssignmentProcess);
}
private EmployeeAssignmentService employeeAssignmentService;
private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
public void setCreateEmployeeAssignmentProcess(CreateEmployeeAssignmentProcess value) {
this.createEmployeeAssignmentProcess = value;
}
}