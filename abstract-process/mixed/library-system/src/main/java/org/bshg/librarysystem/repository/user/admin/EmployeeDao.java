package org.bshg.librarysystem.repository.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.repository.Repository;

public interface EmployeeDao extends Repository<Employee, Long> {
    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}