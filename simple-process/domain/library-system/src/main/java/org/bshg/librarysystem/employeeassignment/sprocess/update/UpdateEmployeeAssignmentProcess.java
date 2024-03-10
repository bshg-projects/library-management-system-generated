package org.bshg.librarysystem.employeeassignment.sprocess.update;

import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;

import java.util.List;

public interface UpdateEmployeeAssignmentProcess {
    EmployeeAssignment run(EmployeeAssignment item);

    List<EmployeeAssignment> run(List<EmployeeAssignment> items);
}
