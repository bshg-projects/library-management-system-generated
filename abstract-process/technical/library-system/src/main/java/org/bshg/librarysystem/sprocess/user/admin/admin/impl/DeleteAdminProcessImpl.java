package org.bshg.librarysystem.sprocess.user.admin.admin.impl;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.services.facade.user.admin.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteAdminProcessImpl extends AbstractDeleteProcessImpl<Admin, AdminService> implements DeleteAdminProcess {
    public DeleteAdminProcessImpl(AdminService service, EmployeeAssignmentService employeeAssignmentService) {
        super(service);
        this.employeeAssignmentService = employeeAssignmentService;
    }

    @Override
    protected void process(Admin item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void deleteAssociatedList(Admin item) {
        deleteEmployeeAssignmentProcess.deleteByAdmin(item);
    }

    private EmployeeAssignmentService employeeAssignmentService;
    private DeleteEmployeeAssignmentProcess deleteEmployeeAssignmentProcess;

    public void setDeleteEmployeeAssignmentProcess(DeleteEmployeeAssignmentProcess value) {
        this.deleteEmployeeAssignmentProcess = value;
    }
}