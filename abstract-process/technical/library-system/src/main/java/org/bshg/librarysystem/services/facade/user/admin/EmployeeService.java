package org.bshg.librarysystem.services.facade.user.admin;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface EmployeeService extends IService<Employee> {
int deleteByAddressId(Long id);
Employee findByAddressId(Long id);
}