package org.bshg.librarysystem.admin.sprocess.delete;
import org.bshg.librarysystem.admin.Admin;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import java.util.List;
public interface DeleteAdminProcess {
void run(Admin item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Admin> items);
}