package org.bshg.librarysystem.sprocess.user.admin.admin.delete;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete.DeleteEmployeeAssignmentProcess;
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