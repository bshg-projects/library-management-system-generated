package org.bshg.librarysystem.employeeassignment.sprocess.create;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import java.util.List;
public interface CreateEmployeeAssignmentProcess {
EmployeeAssignment run(EmployeeAssignment item);
List<EmployeeAssignment> run(List<EmployeeAssignment> items);
}