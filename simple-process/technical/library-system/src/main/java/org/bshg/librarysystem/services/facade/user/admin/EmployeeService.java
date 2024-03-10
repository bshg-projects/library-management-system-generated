package org.bshg.librarysystem.services.facade.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(Long id);

    List<Employee> findAllOptimized();

    List<Employee> findAll();

    Employee create(Employee item);

    Employee edit(Employee item);

    void deleteById(Long id);

    void delete(Employee item);

    void delete(List<Employee> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}