package org.bshg.librarysystem.admin.sprocess.create;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.create.CreateAdminProcess;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
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