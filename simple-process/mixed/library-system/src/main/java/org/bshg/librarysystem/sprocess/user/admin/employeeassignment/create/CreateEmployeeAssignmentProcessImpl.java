package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.create.CreateAdminProcess;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateEmployeeAssignmentProcessImpl implements CreateEmployeeAssignmentProcess {
@Transactional(rollbackFor = Exception.class)
public EmployeeAssignment run(EmployeeAssignment item) {
// Your Creation Logic For 'EmployeeAssignment'
item = service.create(item);
return item;
}
public List<EmployeeAssignment> run(List<EmployeeAssignment> items) {
items.forEach(this::run);
return items;
}
@Autowired private EmployeeAssignmentService service;
@Autowired private EmployeeService employeeService;
@Autowired @Lazy private CreateEmployeeProcess createEmployeeProcess;
@Autowired private AdminService adminService;
@Autowired @Lazy private CreateAdminProcess createAdminProcess;
}