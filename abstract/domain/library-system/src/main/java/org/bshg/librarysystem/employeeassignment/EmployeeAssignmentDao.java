package org.bshg.librarysystem.employeeassignment;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeeAssignmentDao extends Repository<EmployeeAssignment, Long> {
int deleteByAdminId(Long id);
List<EmployeeAssignment> findByAdminId(Long id);
int deleteByEmployeeId(Long id);
List<EmployeeAssignment> findByEmployeeId(Long id);
}