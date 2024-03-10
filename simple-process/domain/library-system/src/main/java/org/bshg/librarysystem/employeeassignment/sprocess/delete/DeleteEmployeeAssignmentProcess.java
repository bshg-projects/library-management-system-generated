package org.bshg.librarysystem.employeeassignment.sprocess.delete;

import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;

import java.util.List;

public interface DeleteEmployeeAssignmentProcess {
    void run(EmployeeAssignment item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<EmployeeAssignment> items);

    void deleteByAdmin(Admin admin);

    void deleteByEmployee(Employee employee);
}