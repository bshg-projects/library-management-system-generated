package org.bshg.librarysystem.employeeassignment.sprocess.update;

import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.delete.DeleteAdminProcess;
import org.bshg.librarysystem.admin.sprocess.update.UpdateAdminProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
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