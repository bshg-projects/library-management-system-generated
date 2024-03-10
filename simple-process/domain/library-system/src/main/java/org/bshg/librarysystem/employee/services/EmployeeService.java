package org.bshg.librarysystem.employee.services;

import org.bshg.librarysystem.employee.Employee;

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