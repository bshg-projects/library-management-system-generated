package org.bshg.librarysystem.employee;
import org.bshg.librarysystem.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EmployeeDao extends JpaRepository<Employee, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByAddressId(Long id);
Employee findByAddressId(Long id);
}