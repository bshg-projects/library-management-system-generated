package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.delete;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;

import java.util.List;

public interface DeleteEmployeeAssignmentProcess {
    void run(EmployeeAssignment item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<EmployeeAssignment> items);

    void deleteByAdmin(Admin admin);

    void deleteByEmployee(Employee employee);
}