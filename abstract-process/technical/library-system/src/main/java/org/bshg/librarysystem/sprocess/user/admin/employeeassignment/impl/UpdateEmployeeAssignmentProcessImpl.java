package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.impl;

import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.UpdateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.UpdateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateEmployeeAssignmentProcessImpl extends AbstractUpdateProcessImpl<EmployeeAssignment, EmployeeAssignmentService> implements UpdateEmployeeAssignmentProcess {
    public UpdateEmployeeAssignmentProcessImpl(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
        super(service);
        this.employeeService = employeeService;
        this.adminService = adminService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAssignment run(EmployeeAssignment item) {
// Your Update Logic For 'EmployeeAssignment'
        item = service.edit(item);
        return item;
    }

    private EmployeeService employeeService;
    private UpdateEmployeeProcess updateEmployeeProcess;
    private DeleteEmployeeProcess deleteEmployeeProcess;

    public void setUpdateEmployeeProcess(UpdateEmployeeProcess value) {
        this.updateEmployeeProcess = value;
    }

    public void setDeleteEmployeeProcess(DeleteEmployeeProcess value) {
        this.deleteEmployeeProcess = value;
    }

    private AdminService adminService;
    private UpdateAdminProcess updateAdminProcess;
    private DeleteAdminProcess deleteAdminProcess;

    public void setUpdateAdminProcess(UpdateAdminProcess value) {
        this.updateAdminProcess = value;
    }

    public void setDeleteAdminProcess(DeleteAdminProcess value) {
        this.deleteAdminProcess = value;
    }
}