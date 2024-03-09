package org.bshg.librarysystem.services.user.admin.employeeassignment;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import java.util.List;
public interface EmployeeAssignmentService {
EmployeeAssignment findById(Long id);
List<EmployeeAssignment> findAllOptimized();
List<EmployeeAssignment> findAll();
EmployeeAssignment create(EmployeeAssignment item);
List<EmployeeAssignment> create(List<EmployeeAssignment> item);
EmployeeAssignment update(EmployeeAssignment item);
List<EmployeeAssignment> update(List<EmployeeAssignment> item);
void deleteById(Long id);
void delete(EmployeeAssignment item);
void delete(List<EmployeeAssignment> items);
void deleteByIdIn(List<Long> ids);
int deleteByAdminId(Long id);
List<EmployeeAssignment> findByAdminId(Long id);
int deleteByEmployeeId(Long id);
List<EmployeeAssignment> findByEmployeeId(Long id);
}