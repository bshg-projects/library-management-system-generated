package org.bshg.librarysystem.sprocess.user.admin.employeeassignment;

import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.admin.create.CreateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.delete.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.update.UpdateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create.CreateEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update.UpdateEmployeeAssignmentProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject EmployeeAssignment Processes (Create, Update, Delete).
 */
@Configuration
public class EmployeeAssignmentInjector {
    @Bean
    public CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
        var bean = new CreateEmployeeAssignmentProcessImpl(service, employeeService, adminService);
        bean.setCreateEmployeeProcess(this.createEmployeeProcess);
        bean.setCreateAdminProcess(this.createAdminProcess);
        return bean;
    }

    @Bean
    public UpdateEmployeeAssignmentProcess updateEmployeeAssignmentProcess(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
        var bean = new UpdateEmployeeAssignmentProcessImpl(service, employeeService, adminService);
        bean.setUpdateEmployeeProcess(this.updateEmployeeProcess);
        bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
        bean.setUpdateAdminProcess(this.updateAdminProcess);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        return bean;
    }

    @Bean
    public DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
        var bean = new DeleteEmployeeAssignmentProcessImpl(service, employeeService, adminService);
        bean.setDeleteAdminProcess(this.deleteAdminProcess);
        bean.setDeleteEmployeeProcess(this.deleteEmployeeProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateEmployeeProcess createEmployeeProcess;
    @Autowired
    @Lazy
    private UpdateEmployeeProcess updateEmployeeProcess;
    @Autowired
    @Lazy
    private CreateAdminProcess createAdminProcess;
    @Autowired
    @Lazy
    private UpdateAdminProcess updateAdminProcess;
    @Autowired
    @Lazy
    private DeleteAdminProcess deleteAdminProcess;
    @Autowired
    @Lazy
    private DeleteEmployeeProcess deleteEmployeeProcess;
}