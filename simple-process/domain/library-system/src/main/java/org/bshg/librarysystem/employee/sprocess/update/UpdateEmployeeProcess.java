package org.bshg.librarysystem.employee.sprocess.update;

import org.bshg.librarysystem.employee.Employee;
import java.util.List;

public interface UpdateEmployeeProcess {
    Employee run(Employee item);
    List<Employee> run(List<Employee> items);
}
