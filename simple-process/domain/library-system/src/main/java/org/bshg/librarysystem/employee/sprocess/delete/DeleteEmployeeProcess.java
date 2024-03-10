package org.bshg.librarysystem.employee.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.employee.Employee;

import java.util.List;

public interface DeleteEmployeeProcess {
    void run(Employee item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Employee> items);

    void deleteByAddress(Address address);
}