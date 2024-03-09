package org.bshg.librarysystem.sprocess.user.admin.admin.create;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.create.CreateAdminProcess;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateAdminProcessImpl implements CreateAdminProcess {
@Transactional(rollbackFor = Exception.class)
public Admin run(Admin item) {
// Your Creation Logic For 'Admin'
item = service.create(item);
createAssociatedList(item);
return item;
}
public List<Admin> run(List<Admin> items) {
items.forEach(this::run);
return items;
}
public void createAssociatedList(Admin item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Admin::getEmployeeAssignment, EmployeeAssignment::setAdmin, createEmployeeAssignmentProcess::run);
}
@Autowired private AdminService service;
@Autowired private EmployeeAssignmentService employeeAssignmentService;
@Autowired @Lazy private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
}