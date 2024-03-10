package org.bshg.librarysystem.repository.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.utils.repository.Repository;

import java.util.List;

public interface EmployeeAssignmentDao extends Repository<EmployeeAssignment, Long> {
    int deleteByAdminId(Long id);

    List<EmployeeAssignment> findByAdminId(Long id);

    int deleteByEmployeeId(Long id);

    List<EmployeeAssignment> findByEmployeeId(Long id);
}