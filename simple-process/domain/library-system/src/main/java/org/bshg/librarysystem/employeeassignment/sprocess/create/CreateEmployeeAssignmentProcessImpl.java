package org.bshg.librarysystem.employeeassignment.sprocess.create;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.create.CreateAdminProcess;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.admin.Admin;
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