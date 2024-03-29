package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteEmployeeAssignmentProcess extends IDeleteProcess<EmployeeAssignment> {
    void deleteByAdmin(Admin admin);

    void deleteByEmployee(Employee employee);
}