package org.bshg.librarysystem.services.facade.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.service.IService;

public interface EmployeeService extends IService<Employee> {
    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}