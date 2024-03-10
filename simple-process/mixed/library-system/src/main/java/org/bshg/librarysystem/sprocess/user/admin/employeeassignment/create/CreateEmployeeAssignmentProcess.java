package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.create;

import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;

import java.util.List;

public interface CreateEmployeeAssignmentProcess {
    EmployeeAssignment run(EmployeeAssignment item);

    List<EmployeeAssignment> run(List<EmployeeAssignment> items);
}