package org.bshg.librarysystem.sprocess.user.admin.admin;
import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.create.CreateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.update.UpdateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.delete.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.create.CreateAdminProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.admin.update.UpdateAdminProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.admin.delete.DeleteAdminProcessImpl;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Admin Processes (Create, Update, Delete).
*/
@Configuration
public class AdminInjector {
@Bean
public CreateAdminProcess createAdminProcess (AdminService service,EmployeeAssignmentService employeeAssignmentService) {
var bean = new CreateAdminProcessImpl(service, employeeAssignmentService);
bean.setCreateEmployeeAssignmentProcess(this.createEmployeeAssignmentProcess);
return bean;
}
@Bean
public UpdateAdminProcess updateAdminProcess (AdminService service,EmployeeAssignmentService employeeAssignmentService) {
var bean = new UpdateAdminProcessImpl(service,employeeAssignmentService);
bean.setUpdateEmployeeAssignmentProcess(this.updateEmployeeAssignmentProcess);
bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
return bean;
}
@Bean
public DeleteAdminProcess deleteAdminProcess(AdminService service,EmployeeAssignmentService employeeAssignmentService) {
var bean = new DeleteAdminProcessImpl(service,employeeAssignmentService);
bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
return bean;
}
@Autowired @Lazy private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
@Autowired @Lazy private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
@Autowired @Lazy private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}