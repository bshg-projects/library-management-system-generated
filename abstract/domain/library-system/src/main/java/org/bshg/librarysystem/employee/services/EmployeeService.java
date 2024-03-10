package org.bshg.librarysystem.employee.services;

import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.utils.service.IService;

public interface EmployeeService extends IService<Employee> {
    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}