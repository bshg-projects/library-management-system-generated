package org.bshg.librarysystem.services.facade.user.admin;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface EmployeeAssignmentService extends IService<EmployeeAssignment> {
int deleteByAdminId(Long id);
List<EmployeeAssignment> findByAdminId(Long id);
int deleteByEmployeeId(Long id);
List<EmployeeAssignment> findByEmployeeId(Long id);
}