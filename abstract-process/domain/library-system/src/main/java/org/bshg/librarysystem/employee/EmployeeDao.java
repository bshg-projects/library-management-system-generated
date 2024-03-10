package org.bshg.librarysystem.employee;

import org.bshg.librarysystem.utils.repository.Repository;

public interface EmployeeDao extends Repository<Employee, Long> {
    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}