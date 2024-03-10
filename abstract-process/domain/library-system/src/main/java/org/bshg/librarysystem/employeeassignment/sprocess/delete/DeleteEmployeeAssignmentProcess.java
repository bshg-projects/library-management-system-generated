package org.bshg.librarysystem.employeeassignment.sprocess.delete;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteEmployeeAssignmentProcess extends IDeleteProcess<EmployeeAssignment> {
    void deleteByAdmin(Admin admin);

    void deleteByEmployee(Employee employee);
}