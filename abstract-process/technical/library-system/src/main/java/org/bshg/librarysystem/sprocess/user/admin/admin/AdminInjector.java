package org.bshg.librarysystem.sprocess.user.admin.admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.CreateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.UpdateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.impl.CreateAdminProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.admin.impl.UpdateAdminProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.admin.impl.DeleteAdminProcessImpl;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
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