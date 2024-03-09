package org.bshg.librarysystem.employeeassignment.sprocess;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.create.CreateAdminProcess;
import org.bshg.librarysystem.admin.sprocess.update.UpdateAdminProcess;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject EmployeeAssignment Processes (Create, Update, Delete).
*/
@Configuration
public class EmployeeAssignmentInjector {
@Bean
public CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess (EmployeeAssignmentService service,EmployeeService employeeService,AdminService adminService) {
var bean = new CreateEmployeeAssignmentProcessImpl(service, employeeService, adminService);
bean.setCreateEmployeeProcess(this.createEmployeeProcess);
bean.setCreateAdminProcess(this.createAdminProcess);
return bean;
}
@Bean
public UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess (EmployeeAssignmentService service,EmployeeService employeeService,AdminService adminService) {
var bean = new UpdateEmployeeAssignmentProcessImpl(service,employeeService,adminService);
bean.setUpdateEmployeeProcess(this.updateEmployeeProcess);
bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
bean.setUpdateAdminProcess(this.updateAdminProcess);
bean.setDeleteAdminProcess(this.deleteAdminProcess);
return bean;
}
@Bean
public DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess(EmployeeAssignmentService service,EmployeeService employeeService,AdminService adminService) {
var bean = new DeleteEmployeeAssignmentProcessImpl(service,employeeService,adminService);
bean.setDeleteAdminProcess(this.deleteAdminProcess);
bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
return bean;
}
@Autowired @Lazy private CreateEmployeeProcess createEmployeeProcess;
@Autowired @Lazy private UpdateEmployeeProcess updateEmployeeProcess;
@Autowired @Lazy private CreateAdminProcess createAdminProcess;
@Autowired @Lazy private UpdateAdminProcess updateAdminProcess;
@Autowired @Lazy private DeleteAdminProcess deleteAdminProcess;
@Autowired @Lazy private DeleteEmployeeProcess deleteEmployeeProcess;
}