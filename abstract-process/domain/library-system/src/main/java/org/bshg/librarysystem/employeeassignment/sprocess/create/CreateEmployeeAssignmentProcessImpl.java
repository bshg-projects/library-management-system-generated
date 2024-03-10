package org.bshg.librarysystem.employeeassignment.sprocess.create;

import org.bshg.librarysystem.admin.services.AdminService;
import org.bshg.librarysystem.admin.sprocess.create.CreateAdminProcess;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateEmployeeAssignmentProcessImpl extends AbstractCreateProcessImpl<EmployeeAssignment, EmployeeAssignmentService> implements CreateEmployeeAssignmentProcess {
    public CreateEmployeeAssignmentProcessImpl(EmployeeAssignmentService service, EmployeeService employeeService, AdminService adminService) {
        super(service);
        this.employeeService = employeeService;
        this.adminService = adminService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAssignment run(EmployeeAssignment item) {
// Your Insert Logic For 'EmployeeAssignment'
        item = service.create(item);
        return item;
    }

    private EmployeeService employeeService;
    private CreateEmployeeProcess createEmployeeProcess;

    public void setCreateEmployeeProcess(CreateEmployeeProcess value) {
        this.createEmployeeProcess = value;
    }

    private AdminService adminService;
    private CreateAdminProcess createAdminProcess;

    public void setCreateAdminProcess(CreateAdminProcess value) {
        this.createAdminProcess = value;
    }
}