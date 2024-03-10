package org.bshg.librarysystem.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    Employee findByAddressId(Long id);
}