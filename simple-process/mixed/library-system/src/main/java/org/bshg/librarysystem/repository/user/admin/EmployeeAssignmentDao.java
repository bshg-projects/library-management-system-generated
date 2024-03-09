package org.bshg.librarysystem.repository.user.admin;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeeAssignmentDao extends JpaRepository<EmployeeAssignment, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAdminId(Long id);
List<EmployeeAssignment> findByAdminId(Long id);
int deleteByEmployeeId(Long id);
List<EmployeeAssignment> findByEmployeeId(Long id);
}