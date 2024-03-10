package org.bshg.librarysystem.sprocess.user.admin.employeeassignment;

import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.CreateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.UpdateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.impl.CreateEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.impl.DeleteEmployeeAssignmentProcessImpl;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.impl.UpdateEmployeeAssignmentProcessImpl;
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