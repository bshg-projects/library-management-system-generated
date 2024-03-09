package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.impl;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.CreateAdminProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateEmployeeAssignmentProcessImpl extends AbstractCreateProcessImpl<EmployeeAssignment, EmployeeAssignmentService> implements CreateEmployeeAssignmentProcess {
public CreateEmployeeAssignmentProcessImpl(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
super(service);
this.employeeService = employeeService;
this.adminService = adminService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public EmployeeAssignment run(EmployeeAssignment item) {
// Your Insert Logic For 'EmployeeAssignment'
item = service.create(item);
return item;
}
private EmployeeService employeeService;
private CreateEmployeeProcess createEmployeeProcess;
public void setCreateEmployeeProcess(CreateEmployeeProcess value) {
this.createEmployeeProcess = value;
}
private AdminService adminService;
private CreateAdminProcess createAdminProcess;
public void setCreateAdminProcess(CreateAdminProcess value) {
this.createAdminProcess = value;
}
}