package org.bshg.librarysystem.admin.sprocess;

import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.create.CreateAdminProcess;
import org.bshg.librarysystem.admin.sprocess.create.CreateAdminProcessImpl;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcess;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcessImpl;
import org.bshg.librarysystem.admin.sprocess.update.UpdateAdminProcess;
import org.bshg.librarysystem.admin.sprocess.update.UpdateAdminProcessImpl;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Admin Processes (Create, Update, Delete).
 */
@Configuration
public class AdminInjector {
    @Bean
    public CreateAdminProcess createAdminProcess(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
        var bean = new CreateAdminProcessImpl(service, employeeAssignmentService);
        bean.setCreateEmployeeAssignmentProcess(this.createEmployeeAssignmentProcess);
        return bean;
    }

    @Bean
    public UpdateAdminProcess updateAdminProcess(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
        var bean = new UpdateAdminProcessImpl(service, employeeAssignmentService);
        bean.setUpdateEmployeeAssignmentProcess(this.updateEmployeeAssignmentProcess);
        bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
        return bean;
    }

    @Bean
    public DeleteAdminProcess deleteAdminProcess(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
        var bean = new DeleteAdminProcessImpl(service, employeeAssignmentService);
        bean.setDeleteEmployeeAssignmentProcess(this.deleteEmployeeAssignmentProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
    @Autowired
    @Lazy
    private UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;
}