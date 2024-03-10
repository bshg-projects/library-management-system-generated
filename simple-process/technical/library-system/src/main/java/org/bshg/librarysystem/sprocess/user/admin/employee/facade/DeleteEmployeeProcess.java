package org.bshg.librarysystem.sprocess.user.admin.employee.facade;

import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.user.admin.Employee;

import java.util.List;

public interface DeleteEmployeeProcess {
    void run(Employee item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Employee> items);

    void deleteByAddress(Address address);
}