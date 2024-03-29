package org.bshg.librarysystem.employeeassignment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeAssignmentDao extends JpaRepository<EmployeeAssignment, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByAdminId(Long id);

    List<EmployeeAssignment> findByAdminId(Long id);

    int deleteByEmployeeId(Long id);

    List<EmployeeAssignment> findByEmployeeId(Long id);
}