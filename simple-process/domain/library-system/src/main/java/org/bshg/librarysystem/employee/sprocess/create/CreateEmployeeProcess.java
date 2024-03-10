package org.bshg.librarysystem.employee.sprocess.create;

import org.bshg.librarysystem.employee.Employee;

import java.util.List;

public interface CreateEmployeeProcess {
    Employee run(Employee item);

    List<Employee> run(List<Employee> items);
}