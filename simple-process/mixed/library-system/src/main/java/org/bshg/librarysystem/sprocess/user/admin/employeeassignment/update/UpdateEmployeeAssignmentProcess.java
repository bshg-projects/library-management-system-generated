package org.bshg.librarysystem.sprocess.user.admin.employeeassignment.update;

import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import java.util.List;

public interface UpdateEmployeeAssignmentProcess {
    EmployeeAssignment run(EmployeeAssignment item);
    List<EmployeeAssignment> run(List<EmployeeAssignment> items);
}
