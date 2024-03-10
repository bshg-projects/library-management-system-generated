package org.bshg.librarysystem.repository.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}