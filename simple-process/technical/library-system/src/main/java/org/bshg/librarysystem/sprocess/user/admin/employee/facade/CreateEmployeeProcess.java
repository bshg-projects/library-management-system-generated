package org.bshg.librarysystem.sprocess.user.admin.employee.facade;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import java.util.List;
public interface CreateEmployeeProcess {
Employee run(Employee item);
List<Employee> run(List<Employee> items);
}