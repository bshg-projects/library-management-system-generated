package org.bshg.librarysystem.employeeassignment.services;

import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface EmployeeAssignmentService extends IService<EmployeeAssignment> {
    int deleteByAdminId(Long id);

    List<EmployeeAssignment> findByAdminId(Long id);

    int deleteByEmployeeId(Long id);

    List<EmployeeAssignment> findByEmployeeId(Long id);
}