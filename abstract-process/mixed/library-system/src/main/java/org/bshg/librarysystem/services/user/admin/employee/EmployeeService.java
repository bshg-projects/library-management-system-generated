package org.bshg.librarysystem.services.user.admin.employee;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.service.IService;

public interface EmployeeService extends IService<Employee> {
    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}